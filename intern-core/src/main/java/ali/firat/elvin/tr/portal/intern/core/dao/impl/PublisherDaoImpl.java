package ali.firat.elvin.tr.portal.intern.core.dao.impl;
import ali.firat.elvin.tr.portal.intern.core.model.Publishers;
import org.springframework.stereotype.Repository;

@Repository
public class PublisherDaoImpl extends HibernateDaoImpl<Publishers,String> {
    public PublisherDaoImpl(){super(Publishers.class);}
    public PublisherDaoImpl(Class<Publishers> persistentClass) {
        super(persistentClass);
    }
}
