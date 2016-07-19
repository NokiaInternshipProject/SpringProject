package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by yektan on 15.07.2016.
 */
@Entity
@Table(name = "books", schema = "intern", catalog = "")
public class Books implements Serializable {
    private int id;
    private String name;
    private int year;
    private int publisherid;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID",unique = true,nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public int getPublisherid(){return publisherid;}

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "YEAR")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (year != books.year) return false;
        if (name != null ? !name.equals(books.name) : books.name != null) return false;

        return true;
    }

    private List<BookAuthor> bookAuthor;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    public List<BookAuthor> getBookAuthor(){return  bookAuthor;}

    public void setBookAuthor(List<BookAuthor> bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


    private List<BookGenre> bookGenre;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    public List<BookGenre> getBookGenre(){return  bookGenre;}
    public void setBookGenre(List<BookGenre> bookGenre) {
        this.bookGenre = bookGenre;
    }


    private Publishers publisher;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PUBLISHERID",referencedColumnName = "ID",insertable = false,updatable = false)
    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
