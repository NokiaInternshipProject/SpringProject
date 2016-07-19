package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by yektan on 15.07.2016.
 */
@Entity
@Table(name = "book_genre", schema = "intern", catalog = "")
public class BookGenre implements Serializable {
    private int id;
    private int genreid;
    private int bookid;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GENREID")
    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "BOOKID")
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookGenre bookGenre = (BookGenre) o;

        if (id != bookGenre.id) return false;
        if (genreid != bookGenre.genreid) return false;
        if (bookid != bookGenre.bookid) return false;

        return true;
    }

    private List<Books> book;
    @ManyToMany
    @JoinColumn(name = "BOOKID", referencedColumnName = "ID", nullable = false)
    public List<Books> getBooks() {
        return book;
    }
    public void setBooks(List<Books> book) {
        this.book = book;
    }


    private List<Genre> genre;
    @ManyToMany
    @JoinColumn(name = "AUTHORID", referencedColumnName = "ID", nullable = false)
    public List<Genre> getGenres() {return genre;}
    public void setGenres(List<Genre> genre) {
        this.genre = genre;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + genreid;
        result = 31 * result + bookid;
        return result;
    }
}
