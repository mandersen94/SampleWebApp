package org.markandersen.j2ee.servlet;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Logs the requests as they are created and destroyed.
 *
 * @author mark@markandersen.org
 */
public class LogSysOutRequestListener implements ServletRequestListener {

    private static final Logger logger = Logger.getLogger(LogSysOutRequestListener.class);

    public LogSysOutRequestListener() {
        logger.info("RequestLoggerListener:<init>.");
    }

    /**
     *
     */
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest servletRequest = (HttpServletRequest) event
                .getServletRequest();
        //
        UUID uuid = UUID.randomUUID();
        MDC.put("txId", uuid.toString());
        logger.info("RequestLoggerListener.requestInitialized(): servletRequest = "
                + servletRequest);

    }

    /**
     *
     */
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest servletRequest = (HttpServletRequest) event
                .getServletRequest();
        MDC.remove("txId");
        logger.info("RequestLoggerListener.requestDestroyed()");
    }

}
