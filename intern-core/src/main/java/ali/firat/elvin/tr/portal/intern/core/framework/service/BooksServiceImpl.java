package ali.firat.elvin.tr.portal.intern.core.framework.service;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.BooksDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service("bookService")
public class BooksServiceImpl extends HibernateServiceImpl<Books, Integer> {

    @Autowired
    BooksDaoImpl booksDao;

    public BooksServiceImpl() {
        super(Books.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<Books,Integer> )((HibernateDaoImpl<?,?>)booksDao));
    }
}
