package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.model.BookGenre;
import org.springframework.stereotype.Repository;

/**
 * Created by yektan on 22.07.2016.
 */
@Repository
public class BookGenreDaoImpl extends HibernateDaoImpl<BookGenre,String> {
    public BookGenreDaoImpl(){super(BookGenre.class);}
    public BookGenreDaoImpl(Class<BookGenre> persistentClass) {
        super(persistentClass);
    }
}
