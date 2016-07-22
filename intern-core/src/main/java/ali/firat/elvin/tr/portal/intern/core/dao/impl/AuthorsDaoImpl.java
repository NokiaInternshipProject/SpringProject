package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import org.springframework.stereotype.Repository;

/**
 * Created by yektan on 22.07.2016.
 */
@Repository
public class AuthorsDaoImpl extends HibernateDaoImpl<Authors,String> {
    public AuthorsDaoImpl(){super(Authors.class);}
    public AuthorsDaoImpl(Class<Authors> persistentClass) {
        super(persistentClass);
    }
}
