package ali.firat.elvin.tr.portal.intern.core.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 06.01.2015<br>
 * Time: 13:03<br>
 */
@Table(name = "users", schema = "intern")
@Entity
public class User implements Serializable {
    private Long id;

    @Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String userName;

    @Column(name = "USER_NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String firstName;

    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    @Column(name = "LAST_NAME", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String email;

    @Column(name = "EMAIL", nullable = false, insertable = true, updatable = true, length = 255, precision = 0)
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    @Column(name = "PASSWORD", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer enabled;

    @Column(name = "ENABLED", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    private Date lastPassChangeDate;

    @Column(name = "LAST_PASS_CHANGE_DATE", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public Date getLastPassChangeDate() {
        return lastPassChangeDate;
    }

    public void setLastPassChangeDate(Date lastPassChangeDate) {
        this.lastPassChangeDate = lastPassChangeDate;
    }

    private String question;


    private List<UserGroupMap> userGroups;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    public List<UserGroupMap> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupMap> userGroups) {
        this.userGroups = userGroups;
    }

}
