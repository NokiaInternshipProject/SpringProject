package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.model.Users;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: monster
 * Date: 2/7/14
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class UsersDaoImpl extends HibernateDaoImpl<Users, String>{
    public UsersDaoImpl() {
        super(Users.class);
    }

    public UsersDaoImpl(Class<Users> persistentClass) {
        super(persistentClass);
    }

}

