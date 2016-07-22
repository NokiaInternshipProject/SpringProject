package ali.firat.elvin.tr.portal.intern.core.dao.impl;
import ali.firat.elvin.tr.portal.intern.core.model.Books;
import org.springframework.stereotype.Repository;


@Repository
public class BooksDaoImpl extends HibernateDaoImpl<Books,String>{
    public BooksDaoImpl(){super(Books.class);}
    public BooksDaoImpl(Class<Books> persistentClass) {
        super(persistentClass);
    }
}
