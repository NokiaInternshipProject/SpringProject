package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: Oktay CEKMEZ<br>
 * Date: 06.01.2015<br>
 * Time: 13:03<br>
 */
@Table(name = "user_group")
@Entity
public class UserGroup implements Serializable {
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

    private String groupName;

    @Column(name = "GROUP_NAME", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private Boolean active;

    @Column(name = "ACTIVE", nullable = true, insertable = true, updatable = true, length = 0, precision = 0)
    @Basic
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private List<UserGroupMap> userGroupMaps;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup", orphanRemoval = true)
    public List<UserGroupMap> getUserGroupMaps() {
        return userGroupMaps;
    }

    public void setUserGroupMaps(List<UserGroupMap> userGroupMaps) {
        this.userGroupMaps = userGroupMaps;
    }

    private List<GroupRoleMap> groupRoleMaps;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userGroup", orphanRemoval = true)
    public List<GroupRoleMap> getGroupRoleMaps() {
        return groupRoleMaps;
    }

    public void setGroupRoleMaps(List<GroupRoleMap> userRoleMaps) {
        this.groupRoleMaps = userRoleMaps;
    }
}
