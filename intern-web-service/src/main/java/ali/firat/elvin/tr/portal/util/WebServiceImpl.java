package ali.firat.elvin.tr.portal.util;

import ali.firat.elvin.tr.portal.intern.core.model.Books;
import ali.firat.elvin.tr.portal.umsp.middleware.ws.RandomService;
import ali.firat.elvin.tr.portal.umsp.middleware.ws.RandomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fozersahin on 8.8.2016.
 */
@javax.jws.WebService(endpointInterface = "ali.firat.elvin.tr.portal.util.WebService")
//@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class WebServiceImpl implements ali.firat.elvin.tr.portal.util.WebService {

    private String hi = new String();

    public void setHi(String hi) {
        this.hi = hi;
    }

    @Autowired
    RandomServiceInterface<Books> randomServiceInterface = new RandomService<Books>();


    public String getHi() {
        return hi;
    }

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    @Override
    public void testRandomClass() {
        System.out.println(randomServiceInterface.testRandom());
    }

    @Override
    public void printRandomBook() {
        String randomBook = new String();
        randomBook = randomServiceInterface.sendRandom();
        System.out.println(randomBook);
    }
}

