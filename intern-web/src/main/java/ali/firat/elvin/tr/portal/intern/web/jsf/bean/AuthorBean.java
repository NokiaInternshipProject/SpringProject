package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.AuthorServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("authorBean")
public class AuthorBean implements Serializable {

    private Authors authors = new Authors();
    private AuthorServiceImpl authorService = new AuthorServiceImpl();
    private NavigatorBean navi = new NavigatorBean();
    private Authors selectedAuthor = new Authors();
    private List<Authors> allAuths;

    //////////////////////////////////////////////////////////////////
    // GETTER SETTER ////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    @Autowired
    public void setAuthorService(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    public AuthorServiceImpl getAuthorService() {
        return authorService;
    }

    public Authors getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Authors selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public void setAllAuths(List<Authors> allAuths) {
        this.allAuths = allAuths;
    }

    public List<Authors> getAllAuths() {
        return allAuths;
    }


    //////////////////////////////////////////////////////////////////////////////
    ////////////////////FUNCTIONS ///////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public void createAuthor(Authors author) {
        try {
            authorService.save(author);
            navi.forwardToPage("/public/auth/authorlist.jsf", "false", "true");

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Authors getAuthorWithURL(int id, String URL) {
        try {
            authors = authorService.get(id);
            navi.forwardToPage("/public/auth/" + URL + ".jsf", "false", "true");
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public void findAuthor(int id) {
        try {
            authors = authorService.get(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Authors> findAllAuthors() {
        try {
            allAuths = authorService.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return allAuths;
    }


    public void updateAuthor(Authors authors) {
        try {
            authorService.update(authors);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}
