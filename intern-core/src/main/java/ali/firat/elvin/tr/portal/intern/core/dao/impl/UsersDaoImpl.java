package ali.firat.elvin.tr.portal.intern.core.dao.impl;
import ali.firat.elvin.tr.portal.intern.core.model.Users;
import org.springframework.stereotype.Repository;


@Repository
public class UsersDaoImpl extends HibernateDaoImpl<Users, String>{
    public UsersDaoImpl() {
        super(Users.class);
    }
    public UsersDaoImpl(Class<Users> persistentClass) {
        super(persistentClass);
    }
}

