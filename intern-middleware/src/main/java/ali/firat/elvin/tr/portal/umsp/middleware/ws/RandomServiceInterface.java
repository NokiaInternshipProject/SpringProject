package ali.firat.elvin.tr.portal.umsp.middleware.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by fozersahin on 10.8.2016.
 */


public interface RandomServiceInterface<T> {

    public void findAll();

    public String sendRandom();

    public int testRandom();
}
