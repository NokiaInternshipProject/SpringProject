package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.GenreServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.framework.service.PublisherServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import ali.firat.elvin.tr.portal.intern.core.model.Publishers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("publisherBean")
@Scope
public class PublisherBean implements Serializable {

    private Publishers publishers = new Publishers();
    private PublisherServiceImpl publisherService = new PublisherServiceImpl();
    private NavigatorBean navi = new NavigatorBean();

    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

    public PublisherServiceImpl getPublisherService() {
        return publisherService;
    }

    @Autowired
    public void setPublisherService(PublisherServiceImpl publisherService) {
        this.publisherService = publisherService;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    public void createPublisher(Publishers publishers) {
        try {
            publisherService.save(publishers);
            navi.forwardToPage("/public/auth/publisherlist.jsf", "false", "true");

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Publishers getPublisherWithURL(int id,String URL) {
        try {
            navi.forwardToPage("/public/auth/"+URL+".jsf", "false", "true");
            publishers = publisherService.get(id);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    public void updatePublisher(Publishers publishers){
        try {
            publisherService.update(publishers);
            navi.forwardToPage("/public/auth/publisherlist.jsf","false","true");
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
