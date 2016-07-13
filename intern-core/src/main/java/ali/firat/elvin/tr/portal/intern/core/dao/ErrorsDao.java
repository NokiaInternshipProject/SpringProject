package ali.firat.elvin.tr.portal.intern.core.dao;

import ali.firat.elvin.tr.portal.intern.core.model.Errors;

/**
 * Created with IntelliJ IDEA.
 * User: monster
 * Date: 2/7/14
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */


public interface ErrorsDao extends HibernateDao<Errors, Long> {

    public Errors findUsersByAdslNo(final String adlsNo);

    public void persistError(String error,String errorSourceString,String adlsNo, String username, String nasip, String uemac, String cpemac) throws Exception ;
}
