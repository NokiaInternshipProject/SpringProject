package ali.firat.elvin.tr.portal.umsp.middleware.ws;

import ali.firat.elvin.tr.portal.intern.core.dao.HibernateDao;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.BooksDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.model.Books;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fozersahin on 10.8.2016.
 */
@Repository("randomBook")
public class RandomService<T> implements RandomServiceInterface<T> {

    @Autowired
    HibernateDao hibernateDao = new BooksDaoImpl();

    @Autowired
    BooksDaoImpl booksDao = new BooksDaoImpl();
    private List<Books> list = new ArrayList<Books>();

    SessionFactory sessionFactory;
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    @Override
    public void findAll() {

        try {
            list = (List<Books>) booksDao.get("1");
        } catch (DaoException e) {

        }
    }

    @Override
    public String sendRandom() {

        if (list.isEmpty())
            System.out.println("List is empty");
        else {
            System.out.println("List Count =" + list.size());
            Random rand = new Random();
            return null;
        }
        return "null";
    }

    @Override
    public int testRandom() {
        Random rand = new Random();
        return rand.nextInt(50);
    }
}
