package ali.firat.elvin.tr.portal.intern.core.dao.impl;

import ali.firat.elvin.tr.portal.intern.core.dao.ErrorsDao;
import ali.firat.elvin.tr.portal.intern.core.model.Errors;
import org.springframework.stereotype.Repository;

/**
 * Created by ocekmez on 3/10/2016.
 */
@Repository
public class ErrorsDaoImpl extends HibernateDaoImpl<Errors, Long> implements ErrorsDao {
    @Override
    public Errors findUsersByAdslNo(String adlsNo) {
        return null;
    }

    @Override
    public void persistError(String error, String errorSourceString, String adlsNo, String username, String nasip, String uemac, String cpemac) throws Exception {

    }
}
