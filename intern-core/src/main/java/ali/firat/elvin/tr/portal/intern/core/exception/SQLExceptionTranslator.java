package ali.firat.elvin.tr.portal.intern.core.exception;

import org.slf4j.Logger;
import org.hibernate.JDBCException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: monster
 * Date: 2/7/14
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class SQLExceptionTranslator implements org.hibernate.exception.spi.SQLExceptionConverter{
    private Logger logger = LoggerFactory.getLogger(SQLExceptionTranslator.class);

    public JDBCException convert(SQLException sqlException, String message, String sql) {
        logger.error("Error for SQL: " + sql);
        SQLErrorCodeSQLExceptionTranslator sqlErrorCodeSQLExceptionTranslator = new SQLErrorCodeSQLExceptionTranslator();
        DataAccessException dataAccessException = sqlErrorCodeSQLExceptionTranslator.translate(message, sql, sqlException);
//        logger.error(dataAccessException.getCause().getMessage());
        JDBCException jdbcException = new JDBCException(dataAccessException.getCause().getMessage(), sqlException, sql);
        return jdbcException;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
