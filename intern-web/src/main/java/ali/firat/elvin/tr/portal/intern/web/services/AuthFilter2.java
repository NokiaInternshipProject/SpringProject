package ali.firat.elvin.tr.portal.intern.web.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ocekmez on 06.08.2014.
 */
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"} )
public class AuthFilter2 implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);
    public AuthFilter2() {

        logger.warn("\n\n*********************************************\n" +
                    "Attention! There is a web filter for all pages\n" +
                    "*********************************************\n\n");
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);

                chain.doFilter(request,response);
         /*{//yeni kullanıcı login'den sonra home sayfasına yönlendiriliyor,
                // buradaki kod'da yeni kullanıcıyı changePassword'e yönlenecek
                logger.warn("New User came, the user should change its password and add a question/answer pair");
                res.sendRedirect(req.getContextPath() + "/changePassword.jsf");
                //FacesContext.getCurrentInstance().getExternalContext().redirect("changePassword.jsf");
                return;
            }*/

        }
        catch(Throwable t) {
            logger.error("When doing filtering, exception occured",t);
        }
    }

    protected void redirectNewUser(){

    }

    public void destroy() {

    }
}