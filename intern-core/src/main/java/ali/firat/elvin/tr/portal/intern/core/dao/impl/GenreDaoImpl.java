package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import org.springframework.stereotype.Repository;

/**
 * Created by yektan on 22.07.2016.
 */
@Repository
public class GenreDaoImpl extends HibernateDaoImpl<Genre,String> {
    public GenreDaoImpl(){super(Genre.class);}
    public GenreDaoImpl(Class<Genre> persistentClass) {
        super(persistentClass);
    }
}
