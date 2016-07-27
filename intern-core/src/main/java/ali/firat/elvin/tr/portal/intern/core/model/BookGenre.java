package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;

/**
 * Created by yektan on 26.07.2016.
 */
@Entity
@Table(name = "book_genre", schema = "intern", catalog = "")
public class BookGenre {
    private int id;
    private int genreid;
    private int bookid;
    private Books booksByBookid;
    private Genre genreByGenreid;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GENREID", nullable = false,insertable = false,updatable = false)
    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "BOOKID", nullable = false,insertable = false,updatable = false)
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

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + genreid;
        result = 31 * result + bookid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BOOKID", referencedColumnName = "ID", nullable = false)
    public Books getBooksByBookid() {
        return booksByBookid;
    }

    public void setBooksByBookid(Books booksByBookid) {
        this.booksByBookid = booksByBookid;
    }

    @ManyToOne
    @JoinColumn(name = "GENREID", referencedColumnName = "ID", nullable = false)
    public Genre getGenreByGenreid() {
        return genreByGenreid;
    }

    public void setGenreByGenreid(Genre genreByGenreid) {
        this.genreByGenreid = genreByGenreid;
    }
}
