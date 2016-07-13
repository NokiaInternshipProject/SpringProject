package ali.firat.elvin.tr.portal.intern.core.exception;

/**
 * Created by IntelliJ IDEA.
 * User: guvenck
 * Date: 11/22/12
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */

public class DaoException extends Exception {

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable t) {
        super(message, t);
    }

    public DaoException(Throwable t) {
        super(t);
    }
}