package ali.firat.elvin.tr.portal.intern.web.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;

/**
 * Created by ocekmez on 4/15/2016.
 */
public class StartupListener implements javax.servlet.ServletContextListener {
    Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
