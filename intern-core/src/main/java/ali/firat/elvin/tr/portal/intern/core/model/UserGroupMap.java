package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 06.01.2015<br>
 * Time: 13:03<br>
 */
@Table(name = "user_group_map")
@Entity
public class UserGroupMap implements Serializable {
    private Long id;
    @GeneratedValue
    @Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Transient
    public String getGroupName() {
        return userGroup.getGroupName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGroupMap that = (UserGroupMap) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    private UserGroup userGroup;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    private User user;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
