package com.iocl.integrated_blocking.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ref_salesoff")
public class RefSalesoff implements Serializable {
	@Id
    private Integer salesoff;
    private String doName;
    private Timestamp updatedDatetime;

    @Basic
    @Column(name = "SALESOFF")
    public Integer getSalesoff() {
        return salesoff;
    }

    public void setSalesoff(Integer salesoff) {
        this.salesoff = salesoff;
    }

    @Basic
    @Column(name = "DO_NAME")
    public String getDoName() {
        return doName;
    }

    public void setDoName(String doName) {
        this.doName = doName;
    }

    @Basic
    @Column(name = "UPDATED_DATETIME")
    public Timestamp getUpdatedDatetime() {
        return updatedDatetime;
    }

    public void setUpdatedDatetime(Timestamp updatedDatetime) {
        this.updatedDatetime = updatedDatetime;
    }

   

    @Override
    public int hashCode() {
        return Objects.hash(salesoff, doName, updatedDatetime);
    }
}
