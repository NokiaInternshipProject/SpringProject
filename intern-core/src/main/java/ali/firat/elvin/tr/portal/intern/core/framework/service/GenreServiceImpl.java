package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.GenreDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service("genreService")
public class GenreServiceImpl extends HibernateServiceImpl<Genre,Long> {
    @Autowired
    GenreDaoImpl genreDao;

    public GenreServiceImpl() {
        super(Genre.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<Genre,Long>)((HibernateDaoImpl<?,?>)genreDao));
    }
}

