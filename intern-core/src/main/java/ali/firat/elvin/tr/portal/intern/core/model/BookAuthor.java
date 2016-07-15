package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;

/**
 * Created by yektan on 15.07.2016.
 */
@Entity
@Table(name = "book_author", schema = "intern", catalog = "")
public class BookAuthor {
    private int id;
    private int bookid;
    private int authorid;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BOOKID")
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "AUTHORID")
    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookAuthor that = (BookAuthor) o;

        if (id != that.id) return false;
        if (bookid != that.bookid) return false;
        if (authorid != that.authorid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookid;
        result = 31 * result + authorid;
        return result;
    }
}
