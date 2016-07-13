package ali.firat.elvin.tr.portal.intern.web.jsf.bean;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ocekmez
 * Date: 10/19/12
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("loginBean")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginBean implements Serializable {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(LoginBean.class);


    @Autowired
    NavigatorBean navigatorBean;


    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        try {
        } catch (Exception e) {
            logger.error("Can not init LoginBean:", e);
        }
    }


}
