package ali.firat.elvin.tr.portal.intern.core.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 06.01.2015<br>
 * Time: 13:03<br>
 */
@Table(name = "user_role")
@Entity
public class UserRole implements Serializable {
    private Long id;

    @Column(name = "ID", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String roleName;

    @Column(name = "ROLE_NAME", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (id != null ? !id.equals(userRole.id) : userRole.id != null) return false;
        if (roleName != null ? !roleName.equals(userRole.roleName) : userRole.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }

    private List<GroupRoleMap> userRoleMaps;

    @Transactional
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole", orphanRemoval = true)
    public List<GroupRoleMap> getUserRoleMaps() {
        return userRoleMaps;
    }

    public void setUserRoleMaps(List<GroupRoleMap> userRoleMaps) {
        this.userRoleMaps = userRoleMaps;
    }
}
