package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by yektan on 15.07.2016.
 */
@Entity
@Table(name = "book_publisher", schema = "intern")
public class BookPublisher {
    private int id;
    private int bookid;
    private int publisherid;

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
    @Column(name = "BOOKID")
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }


    private List<Books> book;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    public List<Books> getBooks() {
        return book;
    }

    public void setBooks(List<Books> book) {
        this.book = book;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookPublisher that = (BookPublisher) o;

        if (id != that.id) return false;
        if (bookid != that.bookid) return false;
        if (publisherid != that.publisherid) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookid;
        result = 31 * result + publisherid;
        return result;
    }
}
