package ali.firat.elvin.tr.portal.intern.core.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by yektan on 26.07.2016.
 */
@Entity
@ManagedBean(name = "genre")
public class Genre {
    private int id;
    private String name;
    private Collection<BookGenre> bookGenresById;

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
    @Column(name = "NAME", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "genreByGenreid")
    public Collection<BookGenre> getBookGenresById() {
        return bookGenresById;
    }

    public void setBookGenresById(Collection<BookGenre> bookGenresById) {
        this.bookGenresById = bookGenresById;
    }
}
