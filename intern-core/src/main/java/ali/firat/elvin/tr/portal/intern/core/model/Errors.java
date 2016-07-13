package ali.firat.elvin.tr.portal.intern.core.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: monster
 * Date: 2/7/14
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */

@Table(name = "ERRORS")
@Entity
public class Errors implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    public Long id;

    @Basic
    @Column(name = "ADSLNO")
    public String adslNo;

    @Basic
    @Column(name = "USERNAME")
    public String username;

    @Basic
    @Column(name = "NASIP")
    public String nasip;

    @Basic
    @Column(name = "UEMAC")
    public String uemac;

    @Basic
    @Column(name = "CPEMAC")
    public String cpemac;

    @Basic
    @Column(name = "ERROR_TIME")
    public Date errorTime;

    @Basic
    @Column(name = "ERROR")
    public String error;

    @Basic
    @Column(name = "ERROR_SOURCE")
    public String errorSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdslNo() {
        return adslNo;
    }

    public void setAdslNo(String adslNo) {
        this.adslNo = adslNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNasip() {
        return nasip;
    }

    public void setNasip(String nasip) {
        this.nasip = nasip;
    }

    public String getUemac() {
        return uemac;
    }

    public void setUemac(String uemac) {
        this.uemac = uemac;
    }

    public String getCpemac() {
        return cpemac;
    }

    public void setCpemac(String cpemac) {
        this.cpemac = cpemac;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorSource() {
        return errorSource;
    }

    public void setErrorSource(String errorSource) {
        this.errorSource = errorSource;
    }
}
