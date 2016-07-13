package ali.firat.elvin.tr.portal.intern.web.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: sakkuzu
 * Date: 05.12.2014
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class SpringSessionListener implements HttpSessionListener {
    Logger logger = LoggerFactory.getLogger(SpringSessionListener.class);
    private boolean eventOccurring_ = false;
    public static int numOfActiveHttpSessions = 0;

    public synchronized void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        if (session != null) {
            numOfActiveHttpSessions++;
            String id = session.getId();
            logger.info("SESSION CREATED with Session ID = [" + id + "]");
            logger.debug("numOfActiveHttpSessions = " + numOfActiveHttpSessions);
        } else {
            logger.info("Null Session ?");
        }


    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        numOfActiveHttpSessions--;
        if (session != null) {
            logger.info("SESSION DESTROYED with Session ID = " + session.getId());
        } else {
            logger.info("Destroyed Session");
        }
    }
}