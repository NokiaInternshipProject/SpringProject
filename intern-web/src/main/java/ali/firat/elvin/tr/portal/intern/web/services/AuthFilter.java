package ali.firat.elvin.tr.portal.intern.web.services;

import ali.firat.elvin.tr.portal.intern.web.jsf.bean.LoginBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.context.FacesContext;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



/**
 * Created by ocekmez on 06.08.2014.
 */
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"} )
@Component
public class AuthFilter implements Filter {
    private static final Logger Logger = LoggerFactory.getLogger(AuthFilter.class);

   /* @Autowired
    SessionDataService sessionDataService;*/

    @Autowired
    LoginBean loginBean;

    @Autowired
    SessionService sessionService;



    public AuthFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        Logger.info("AuthFilter INITIALIZATION");

    }

    private boolean isAJAXRequest(HttpServletRequest request) {
        boolean check = false;
        String facesRequest = request.getHeader("Faces-Request");
        if (facesRequest != null && facesRequest.equals("partial/ajax")) {
            check = true;
        }
        return check;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
            return;

        } catch (Exception t) {
            Logger.error("When doing filtering, exception occured", t);
            throw new ServletException();
        }
    }


    @SuppressWarnings("unchecked")
    public static <T> T findBean(String beanName) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
    }

    public void destroy() {
        Logger.info("FILTER DESTROY");
    }


               /* ServletContext sc = session.getServletContext();
            WebApplicationContext appContext =
                    WebApplicationContextUtils.getWebApplicationContext(sc);
            LoginBean l2 = (LoginBean) appContext.getBean("loginBean");
            logger.info("myHashCode-appContext:" + loginBean.getMyHashCode());*/

            /* if (session != null) {
                String id = session.getId();
                ThreadContext.put("sessionId", id);//faces yok ki suan login bean'i olusturacak bi tetikleyici yok
                LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");

            }

            String requestURI = req.getRequestURI();
            if (!requestURI.contains("/resources/")) {
                logger.debug("Requested URI = " + requestURI);
            }

            ServletContext sc = session.getServletContext();
            WebApplicationContext appContext =
                    WebApplicationContextUtils.getWebApplicationContext(sc);
            LoginBean sampleSession = (LoginBean) appContext.getBean("loginBean");

            if (requestURI.contains("index.jsp")) {
                String pathInfo = ((HttpServletRequest) request).getQueryString();

                if (session != null) {
                    String id = session.getId();
                    logger.info("Incoming http request with Session id = " + id);
                    logger.info("Creation Time = " + session.getCreationTime());
                    logger.info("MaxInactiveInterval = " + session.getMaxInactiveInterval());
                    logger.info("Last Accessed Time = " + session.getLastAccessedTime());
                }
                logger.info("Captured query string = " + pathInfo);

                String nasip = req.getParameter("n");

                LoginBean loginBean = sessionDataService.getLoginBean();

                String sso_adslno = req.getHeader("sso_adslno");
                String username = "TTNET\\" + req.getHeader("sso_uid");

            }
*/


          /*  logger.debug("#################################### SSO PARAMETERS ###########################################################");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<String> iterator = parameterMap.keySet().iterator();
        logger.debug("parameterMap = ");
        while (iterator.hasNext()) {
            String next = iterator.next();
            String[] strings = parameterMap.get(next);
            logger.debug(next + " = " + strings[0]);
        }

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();
        String serverName = request.getServerName();
        logger.debug("requestURI = " + requestURI);
        logger.debug("contextPath = " + contextPath);
        logger.debug("servletPath = " + servletPath);
        logger.debug("queryString = " + queryString);
        logger.debug("remoteAddr = " + remoteAddr);
        logger.debug("serverName = " + serverName);
        logger.debug("Received Headers From SSO : ");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            logger.info(s + " = " + request.getHeader(s));
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                logger.debug("Cookie = " + cookieName);
            }
        }
        LoginBean g = findBean("loginBean");

        logger.info("###############################################################################################");*/
}