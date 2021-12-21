package com.iocl.integrated_blocking.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sap_block_customers")
public class SapBlockCustomers  implements Serializable{

    @Id
    @Column(name = "CUSTCODE")
    private Integer custcode;
    @Column(name = "SAP_BLOCK_STATUS")
    private String sapBlockStatus;
    @Column(name = "BLOCK_ID")
    private String blockId;
    @Column(name = "BLOCK_ATTEMPT_NO")
    private Integer blockAttemptNo;
    @Column(name = "BLOCK_DATE")
    private Timestamp blockDate;
    @Column(name = "SAP_BLOCK_MSG")
    private String sapBlockMsg;

    @Override
    public String toString() {
        return "SapBlockCustomers{" +
                "custcode=" + custcode +
                ", sapBlockStatus='" + sapBlockStatus + '\'' +
                ", blockId='" + blockId + '\'' +
                ", blockAttemptNo=" + blockAttemptNo +
                ", blockDate=" + blockDate +
                ", sapBlockMsg='" + sapBlockMsg + '\'' +
                ", blockConfDatetime=" + blockConfDatetime +
                ", blockFlag='" + blockFlag + '\'' +
                ", salesoffCode='" + salesoffCode + '\'' +
                ", salesorgCode='" + salesorgCode + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", smsStatus='" + smsStatus + '\'' +
                ", smsDatetime=" + smsDatetime +
                ", createDatetime=" + createDatetime +
                ", dateUpdated=" + dateUpdated +
                ", smsText='" + smsText + '\'' +
                ", division='" + division + '\'' +
                '}';
    }

    @Column(name = "BLOCK_CONF_DATETIME")
    private Timestamp blockConfDatetime;
    @Column(name = "BLOCK_FLAG")
    private String blockFlag;
    @Column(name = "SALESOFF_CODE")
    private String salesoffCode;
    @Column(name = "SALESORG_CODE")
    private String salesorgCode;
    @Column(name = "MOBILE_NO")
    private String mobileNo;
    @Column(name = "SMS_STATUS")
    private String smsStatus;
    @Column(name = "SMS_DATETIME")
    private Timestamp smsDatetime;

    public Integer getCustcode() {
        return custcode;
    }

    public void setCustcode(Integer custcode) {
        this.custcode = custcode;
    }

    public String getSapBlockStatus() {
        return sapBlockStatus;
    }

    public void setSapBlockStatus(String sapBlockStatus) {
        this.sapBlockStatus = sapBlockStatus;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockAttemptNo() {
        return blockAttemptNo;
    }

    public void setBlockAttemptNo(Integer blockAttemptNo) {
        this.blockAttemptNo = blockAttemptNo;
    }

    public Timestamp getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(Timestamp blockDate) {
        this.blockDate = blockDate;
    }

    public String getSapBlockMsg() {
        return sapBlockMsg;
    }

    public void setSapBlockMsg(String sapBlockMsg) {
        this.sapBlockMsg = sapBlockMsg;
    }

    public Timestamp getBlockConfDatetime() {
        return blockConfDatetime;
    }

    public void setBlockConfDatetime(Timestamp blockConfDatetime) {
        this.blockConfDatetime = blockConfDatetime;
    }

    public String getBlockFlag() {
        return blockFlag;
    }

    public void setBlockFlag(String blockFlag) {
        this.blockFlag = blockFlag;
    }

    public String getSalesoffCode() {
        return salesoffCode;
    }

    public void setSalesoffCode(String salesoffCode) {
        this.salesoffCode = salesoffCode;
    }

    public String getSalesorgCode() {
        return salesorgCode;
    }

    public void setSalesorgCode(String salesorgCode) {
        this.salesorgCode = salesorgCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public Timestamp getSmsDatetime() {
        return smsDatetime;
    }

    public void setSmsDatetime(Timestamp smsDatetime) {
        this.smsDatetime = smsDatetime;
    }

    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Column(name = "CREATE_DATETIME")
    private Timestamp createDatetime;
    @Column(name = "DATE_UPDATED")
    private Timestamp dateUpdated;
    @Column(name = "SMS_TEXT")
    private String smsText;
    @Column(name = "DIVISION")
    private String division;

  }
