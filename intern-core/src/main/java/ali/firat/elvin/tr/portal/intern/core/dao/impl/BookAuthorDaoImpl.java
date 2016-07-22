package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import ali.firat.elvin.tr.portal.intern.core.model.BookAuthor;
import org.springframework.stereotype.Repository;

/**
 * Created by yektan on 22.07.2016.
 */
@Repository
public class BookAuthorDaoImpl extends HibernateDaoImpl<BookAuthor,String> {
    public BookAuthorDaoImpl(){super(BookAuthor.class);}
    public BookAuthorDaoImpl(Class<BookAuthor> persistentClass) {
        super(persistentClass);
    }
}
