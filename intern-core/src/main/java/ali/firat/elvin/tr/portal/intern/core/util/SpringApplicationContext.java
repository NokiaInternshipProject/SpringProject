package ali.firat.elvin.tr.portal.intern.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: guvenck
 * Date: Sep 29, 2010
 * Time: 9:31:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
       return applicationContext.getBean(name);
    }
}
