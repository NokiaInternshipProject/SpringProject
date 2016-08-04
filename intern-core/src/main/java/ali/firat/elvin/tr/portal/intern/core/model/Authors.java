package ali.firat.elvin.tr.portal.intern.core.model;

import net.sf.ehcache.config.PersistenceConfiguration;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by yektan on 26.07.2016.
 */
@Entity
@ManagedBean(name="author")
public class Authors {
    private int id;
    private String name;
    private String surname;
    private Collection<BookAuthor> bookAuthorsById;

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
    @Column(name = "NAME", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "SURNAME", nullable = true, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors authors = (Authors) o;

        if (id != authors.id) return false;
        if (name != null ? !name.equals(authors.name) : authors.name != null) return false;
        if (surname != null ? !surname.equals(authors.surname) : authors.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "authorsByAuthorid")
    public Collection<BookAuthor> getBookAuthorsById() {
        return bookAuthorsById;
    }

    public void setBookAuthorsById(Collection<BookAuthor> bookAuthorsById) {
        this.bookAuthorsById = bookAuthorsById;
    }
}
