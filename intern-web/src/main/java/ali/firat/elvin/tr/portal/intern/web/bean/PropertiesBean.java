package ali.firat.elvin.tr.portal.intern.web.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: sakkuzu
 * Date: 09.01.2015
 * Time: 15:46
 * To change this template use File | Settings | File Templates.
 */

@Component
@Scope("singleton")
public class PropertiesBean {
    @Value("${iframe.url}")
    String iframeUrl;

    @Value("${domain.prefix}")
    String prefix;

    public String getIframeUrl() {
        return iframeUrl;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setIframeUrl(String iframeUrl) {
        this.iframeUrl = iframeUrl;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
