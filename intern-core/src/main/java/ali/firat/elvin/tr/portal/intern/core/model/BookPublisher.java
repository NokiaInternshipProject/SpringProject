package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;

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
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BOOKID")
    public int getKitapId() {
        return bookid;
    }

    public void setKitapId(int bookid) {
        this.bookid = bookid;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public int getYayineviId() {
        return publisherid;
    }

    public void setYayineviId(int publisherid) {
        this.publisherid = publisherid;
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
