package ali.firat.elvin.tr.portal.intern.core.framework.service;

import ali.firat.elvin.tr.portal.intern.core.dao.impl.HibernateDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.dao.impl.UsersDaoImpl;
import ali.firat.elvin.tr.portal.intern.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

/**
 * Created by ocekmez on 3/11/2016.
 */
@org.springframework.stereotype.Service("userService")
public class UserServiceImpl extends HibernateServiceImpl<User, Long> {
    @Autowired
    UsersDaoImpl usersDao;

    public UserServiceImpl() {
        super(User.class);
    }

    @PostConstruct
    public void init() {
        setHibernateDao((HibernateDaoImpl<User,Long> )  ((HibernateDaoImpl<?, ?>)usersDao));
    }
}
