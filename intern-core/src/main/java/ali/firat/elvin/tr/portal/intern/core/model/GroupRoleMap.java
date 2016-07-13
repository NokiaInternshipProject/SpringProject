package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 06.01.2015<br>
 * Time: 13:03<br>
 */
@javax.persistence.Table(name = "group_role_map")
@Entity
public class GroupRoleMap implements Serializable {
    private Long id;
    @GeneratedValue
    @javax.persistence.Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupRoleMap that = (GroupRoleMap) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    private UserGroup userGroup;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    private UserRole userRole;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false)
    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
