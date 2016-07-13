package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 16.01.2015<br>
 * Time: 16:41<br>
 */

@Component("navigatorBean")
@Scope("session")
public class NavigatorBean {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(NavigatorBean.class);

    public void forwardToPage(String page, String redirect, String addContext) throws IOException {
        if(addContext.contains("true"))
            page =FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + page;
        if(redirect.contains("true"))
            page = page + "?faces-redirect=true";



        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect(page);
        }catch (Exception e){
            logger.error("Can't redirect for url:" + page);
        }

    }
}
