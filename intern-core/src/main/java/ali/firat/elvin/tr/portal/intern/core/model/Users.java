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

@Table(name = "USERS")
@Entity
public class Users implements Serializable {

    @Id
    @Column(name = "ADSL_NO")
    public String adslNo;

    @Basic
    @Column(name = "CPE_MAC")
    public String cpeMac;

    @Basic
    @Column(name = "ENABLED")
    public String enabled;

    @Basic
    @Column(name = "QUOTA_VOLUME_EXCEEDED")
    public String quotaVolumeExceeded;

    @Basic
    @Column(name = "QUOTA_DURATION_EXCEEDED")
    public String quotaDurationExceeded;

    @Basic
    @Column(name = "CPE_QUOTA_VOLUME_EXCEEDED")
    public String cpeQuotaVolumeExceeded;

    @Basic
    @Column(name = "CPE_QUOTA_DURATION_EXCEEDED")
    public String cpeQuotaDurationExceeded;

    @Basic
    @Column(name = "VALIDITY_TIME")
    public Date validityTime;

    @Basic
    @Column(name = "BLACKLIST_USER")
    public String blacklistUser;

    @Basic
    @Column(name = "ADSL_USERNAME")
    public String adslUsername;

    @Basic
    @Column(name = "ACTIVATION_STATUS")
    public String activationStatus;

    @Basic
    @Column(name = "OPT_IN_DATE")
    public Date optInDate;

    @Basic
    @Column(name = "MODEM_ID")
    public Integer modemId;

    public Integer getModemId() {
        return modemId;
    }

    public void setModemId(Integer modemId) {
        this.modemId = modemId;
    }

    public String getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(String activationStatus) {
        this.activationStatus = activationStatus;
    }

    public Date getOptInDate() {
        return optInDate;
    }

    public void setOptInDate(Date optInDate) {
        this.optInDate = optInDate;
    }

    public String getAdslNo() {
        return adslNo;
    }

    public void setAdslNo(String adslNo) {
        this.adslNo = adslNo;
    }

    public String getCpeMac() {
        return cpeMac;
    }

    public void setCpeMac(String cpeMac) {
        this.cpeMac = cpeMac;
    }

    public String getAdslUsername() {
        return adslUsername;
    }

    public void setAdslUsername(String adslUsername) {
        this.adslUsername = adslUsername;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getQuotaVolumeExceeded() {
        return quotaVolumeExceeded;
    }

    public void setQuotaVolumeExceeded(String quotaVolumeExceeded) {
        this.quotaVolumeExceeded = quotaVolumeExceeded;
    }

    public String getQuotaDurationExceeded() {
        return quotaDurationExceeded;
    }

    public void setQuotaDurationExceeded(String quotaDurationExceeded) {
        this.quotaDurationExceeded = quotaDurationExceeded;
    }

    public String getCpeQuotaVolumeExceeded() {
        return cpeQuotaVolumeExceeded;
    }

    public void setCpeQuotaVolumeExceeded(String cpeQuotaVolumeExceeded) {
        this.cpeQuotaVolumeExceeded = cpeQuotaVolumeExceeded;
    }

    public String getCpeQuotaDurationExceeded() {
        return cpeQuotaDurationExceeded;
    }

    public void setCpeQuotaDurationExceeded(String cpeQuotaDurationExceeded) {
        this.cpeQuotaDurationExceeded = cpeQuotaDurationExceeded;
    }

    public Date getValidityTime() {
        return validityTime;
    }

    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    public String getBlacklistUser() {
        return blacklistUser;
    }

    public void setBlacklistUser(String blacklistUser) {
        this.blacklistUser = blacklistUser;
    }

    @Override
    public String toString() {
        return "Users{" +
                "adslNo='" + adslNo + '\'' +
                ", cpeMac='" + cpeMac + '\'' +
                ", enabled='" + enabled + '\'' +
                ", quotaVolumeExceeded='" + quotaVolumeExceeded + '\'' +
                ", quotaDurationExceeded='" + quotaDurationExceeded + '\'' +
                ", cpeQuotaVolumeExceeded='" + cpeQuotaVolumeExceeded + '\'' +
                ", cpeQuotaDurationExceeded='" + cpeQuotaDurationExceeded + '\'' +
                ", validityTime=" + validityTime +
                ", blacklistUser='" + blacklistUser + '\'' +
                ", adslUsername='" + adslUsername + '\'' +
                ", activationStatus='" + activationStatus + '\'' +
                ", optInDate=" + optInDate +
                '}';
    }
}
