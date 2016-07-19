package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by yektan on 15.07.2016.
 */
@Entity
public class Genre implements Serializable{
    private int id;
    private String name;

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
    @Column(name = "NAME")
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

    private List<BookGenre> bookGenre;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "genres")
    public List<BookGenre> getBookGenre(){return  bookGenre;}
    public void setBookGenre(List<BookGenre> bookGenre) {
        this.bookGenre = bookGenre;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
