package ali.firat.elvin.tr.portal.webservice;

import java.io.Serializable;

import ali.firat.elvin.tr.portal.intern.core.framework.service.HibernateService;
import ali.firat.elvin.tr.portal.intern.core.framework.service.HibernateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * Created by fozersahin on 9.8.2016.
 */
@WebService(endpointInterface = "ali.firat.elvin.tr.portal.webservice.WebServiceClass")
public class WebServiceClassImpl implements WebServiceClass {

//
//    @Autowired
//    RandomServiceInterface<Books> randomServiceInterface = new RandomService();
//
//    @Override
//    public Books getRandomBook() {
//        return null;
//    }

    @Override
    public int getRandom() {
        return 10;
    }
}
