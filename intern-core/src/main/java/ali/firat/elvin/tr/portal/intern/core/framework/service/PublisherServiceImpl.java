package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.PublisherDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Publishers;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@org.springframework.stereotype.Service("publisherService")
public class PublisherServiceImpl extends HibernateServiceImpl<Publishers, Long>  {
    @Autowired
    PublisherDaoImpl publisherDao;

    public PublisherServiceImpl() {
        super(Publishers.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<Publishers,Long>)((HibernateDaoImpl<?,?>)publisherDao));
    }
}
