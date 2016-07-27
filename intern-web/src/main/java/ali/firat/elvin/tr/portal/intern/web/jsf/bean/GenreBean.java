package ali.firat.elvin.tr.portal.intern.web.jsf.bean;

import ali.firat.elvin.tr.portal.intern.core.exception.DaoException;
import ali.firat.elvin.tr.portal.intern.core.framework.service.GenreServiceImpl;
import ali.firat.elvin.tr.portal.intern.core.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by yektan on 27.07.2016.
 */

@Component("genreBean")
@Scope
public class GenreBean implements Serializable {

    private Genre genre = new Genre();
    private GenreServiceImpl genreService = new GenreServiceImpl();
    private NavigatorBean navi = new NavigatorBean();

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public GenreServiceImpl getGenreService() {
        return genreService;
    }

    @Autowired
    public void setGenreService(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    public NavigatorBean getNavi() {
        return navi;
    }

    public void setNavi(NavigatorBean navi) {
        this.navi = navi;
    }

    public void createGenre(Genre genre) {
        try {
            genreService.save(genre);
            navi.forwardToPage("/public/auth/index.jsf", "false", "true");

        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Genre getGenreWithURL(int id,String URL) {
        try {
            navi.forwardToPage("/public/auth/"+URL+".jsf", "false", "true");
            genre = genreService.get(id);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return genre;
    }

    public void updateGenre(Genre genre){
        try {
            genreService.update(genre);
            navi.forwardToPage("/public/auth/genrelist.jsf","false","true");
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
