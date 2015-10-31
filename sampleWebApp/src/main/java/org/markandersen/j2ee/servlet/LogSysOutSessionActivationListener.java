package org.markandersen.j2ee.servlet;

import org.apache.log4j.Logger;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class LogSysOutSessionActivationListener implements HttpSessionActivationListener {

    private static final Logger logger = Logger.getLogger(LogSysOutSessionActivationListener.class);

    public LogSysOutSessionActivationListener() {
        logger.info("SessionActivationListener.<init>");
    }

    /**
     *
     */
    public void sessionDidActivate(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        logger.info("SessionActivationListener.sessionDidActiviate(): id = "
                        + session.getId()
                        + ", creationTime = "
                        + new Date(session.getCreationTime()));

    }

    /**
     *
     */
    public void sessionWillPassivate(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        logger.info("SessionActivationListener.sessionWillPassivate(): id = "
                        + session.getId()
                        + ", creationTime = "
                        + new Date(session.getCreationTime()));

    }

}
