package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.AuthorsDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service("authorService")
public class AuthorServiceImpl extends HibernateServiceImpl<Authors,Integer> {
    @Autowired
    AuthorsDaoImpl authorsDao;

    public AuthorServiceImpl() {
        super(Authors.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<Authors,Integer>)((HibernateDaoImpl<?,?>)authorsDao));
    }
}
