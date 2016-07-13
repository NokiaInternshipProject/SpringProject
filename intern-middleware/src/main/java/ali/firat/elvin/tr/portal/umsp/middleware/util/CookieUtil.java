package ali.firat.elvin.tr.portal.intern.middleware.util;

import java.net.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sakkuzu
 * Date: 05.11.2014
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class CookieUtil {
    public void getCookieUsingCookieHandler(String siteUrl) {
        try {
            // Instantiate CookieManager;
            // make sure to set CookiePolicy
            CookieManager manager = new CookieManager();
            manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            CookieHandler.setDefault(manager);

            // get content from URLConnection;
            // cookies are set by web site
//            URL url = new URL("http://host.example.com");
            URL url = new URL(siteUrl);
            URLConnection connection = url.openConnection();
            connection.getContent();

            // get cookies from underlying
            // CookieStore
            CookieStore cookieJar =  manager.getCookieStore();
            List<HttpCookie> cookies =
                    cookieJar.getCookies();
            for (HttpCookie cookie: cookies) {
                System.out.println("CookieHandler retrieved cookie: " + cookie);
            }
        } catch(Exception e) {
            System.out.println("Unable to get cookie using CookieHandler");
            e.printStackTrace();
        }
    }


    public void setCookieUsingCookieHandler(String siteUrl) {
        try {
            // instantiate CookieManager
            CookieManager manager = new CookieManager();
            CookieHandler.setDefault(manager);
            CookieStore cookieJar =  manager.getCookieStore();

            // create cookie
            HttpCookie cookie = new HttpCookie("UserName", "serhat Doe");

            // add cookie to CookieStore for a
            // particular URL
//            URL url = new URL("http://host.example.com");
            URL url = new URL(siteUrl);
            cookieJar.add(url.toURI(), cookie);
            System.out.println("Added cookie using cookie handler");
        } catch(Exception e) {
            System.out.println("Unable to set cookie using CookieHandler");
            e.printStackTrace();
        }
    }

}
