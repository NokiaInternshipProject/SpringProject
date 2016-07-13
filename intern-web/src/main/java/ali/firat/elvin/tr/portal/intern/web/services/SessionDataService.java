package ali.firat.elvin.tr.portal.intern.web.services;


import ali.firat.elvin.tr.portal.intern.web.jsf.bean.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: sakkuzu
 * Date: 05.12.2014
 * Time: 23:00
 * To change this template use File | Settings | File Templates.
 */
@Service
public class SessionDataService {
    @Autowired
    LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }


  /*  @Autowired
    SessionBasedUser sessionBasedUser;

    public SessionBasedUser getSessionBasedUser() {
        return sessionBasedUser;
    }

    public void setSessionBasedUser(SessionBasedUser sessionBasedUser) {
        this.sessionBasedUser = sessionBasedUser;
    }*/
}
