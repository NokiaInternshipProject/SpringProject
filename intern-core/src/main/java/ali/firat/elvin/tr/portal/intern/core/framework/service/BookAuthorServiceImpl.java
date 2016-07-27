package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.BookAuthorDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.BookAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service("bookAuthorService")
public class BookAuthorServiceImpl extends HibernateServiceImpl<BookAuthor,Integer> {
    @Autowired
    BookAuthorDaoImpl bookAuthorDao;

    public BookAuthorServiceImpl() {
        super(BookAuthor.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<BookAuthor,Integer>)((HibernateDaoImpl<?,?>)bookAuthorDao));
    }
}
