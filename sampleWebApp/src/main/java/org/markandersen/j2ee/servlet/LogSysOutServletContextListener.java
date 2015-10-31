package org.markandersen.j2ee.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author mark@markandersen.org
 */
public class LogSysOutServletContextListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(LogSysOutServletContextListener.class);

    public LogSysOutServletContextListener() {
        logger.info("ServletContextListenerImpl.<init>()");
    }

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        logger.info("ServletContextListenerImpl.contextDestroyed(): servletContext = "
                        + servletContext);

    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        logger.info("ServletContextListenerImpl.contextInitialized(): servletContext = "
                        + servletContext);
    }

}
