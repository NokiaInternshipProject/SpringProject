package ali.firat.elvin.tr.portal.intern.core.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by yektan on 26.07.2016.
 */
@Entity
@ManagedBean(name = "book")
public class Books {

    @ManagedProperty(value = "#{param.bookID}")
    private int id;
    private String name;
    private Integer year;
    private int publisherid;
    private Publishers publishersByPublisherid;
    private List<BookAuthor> bookAuthorsById;
    private List<BookGenre> bookGenresById;

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
    @Column(name = "NAME", nullable = true, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "YEAR", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public int getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(int publisherid) {
        this.publisherid = publisherid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (publisherid != books.publisherid) return false;
        if (name != null ? !name.equals(books.name) : books.name != null) return false;
        if (year != null ? !year.equals(books.year) : books.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + publisherid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PUBLISHERID", referencedColumnName = "ID", nullable = true,insertable = false,updatable = false)
    public Publishers getPublishersByPublisherid() {
        return publishersByPublisherid;
    }

    public void setPublishersByPublisherid(Publishers publishersByPublisherid) {
        this.publishersByPublisherid = publishersByPublisherid;
    }

    @OneToMany(mappedBy = "booksByBookid")
    public List<BookAuthor> getBookAuthorsById() {
        return bookAuthorsById;
    }

    public void setBookAuthorsById(List<BookAuthor> bookAuthorsById) {
        this.bookAuthorsById = bookAuthorsById;
    }

    @OneToMany(mappedBy = "booksByBookid")
    public List<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(List<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }

    @Override
    public String toString() {
        return "Book id =" + getId() + "Book Name = " + getName() + "Book Publish Year" + getYear();
    }
}
