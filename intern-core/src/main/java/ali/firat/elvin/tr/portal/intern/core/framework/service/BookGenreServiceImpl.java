package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.BookGenreDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.BookGenre;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service("bookGenreService")
public class BookGenreServiceImpl extends HibernateServiceImpl<BookGenre,Integer> {
    @Autowired
    BookGenreDaoImpl bookGenreDao;

    public BookGenreServiceImpl() {
        super(BookGenre.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<BookGenre,Integer>)((HibernateDaoImpl<?,?>)bookGenreDao));
    }
}
