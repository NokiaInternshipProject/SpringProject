package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.BooksServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by yektan on 27.07.2016.
 */

@Component
@Scope
public class BookBean implements Serializable {

    private Books books = new Books();
    private BooksServiceImpl booksService = new BooksServiceImpl();
    private NavigatorBean navi = new NavigatorBean();


    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    @Autowired
    public void setBooksService(BooksServiceImpl booksService) {
        this.booksService = booksService;
    }

    public BooksServiceImpl getBooksService() {
        return booksService;
    }

    public void createBook(Books book) {
        try {
            booksService.save(book);
            navi.forwardToPage("/public/auth/index.jsf", "false", "true");

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Books getBookWithURL(int id,String URL) {
        try {
            navi.forwardToPage("/public/auth/"+URL+".jsf", "false", "true");
            books = booksService.get(id);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void updateBook(Books book){
        try {
            booksService.update(book);
            navi.forwardToPage("/public/auth/index.jsf","false","true");
        }catch (DaoException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
