package org.markandersen.j2ee.servlet;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class LogSysOutSessionAttributeListener implements HttpSessionAttributeListener {

    private static Logger logger = Logger.getLogger(LogSysOutSessionAttributeListener.class);

    public LogSysOutSessionAttributeListener() {
        logger.info("SessionAttributeListener.<init>");
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        logger.info("SessionAttributeListener.attributeAdded(): attributeName "
                        + name);
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        logger.info("SessionAttributeListener.attributeRemoved(): attributeName "
                        + name);

    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        logger.info("SessionAttributeListener.attributeReplaced(): attributeName "
                        + name);

    }

}
