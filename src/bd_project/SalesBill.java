/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author data base
 */
@Entity
@Table(name = "SALES_BILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesBill.findAll", query = "SELECT s FROM SalesBill s")
    , @NamedQuery(name = "SalesBill.findBySId", query = "SELECT s FROM SalesBill s WHERE s.sId = :sId")
    , @NamedQuery(name = "SalesBill.findByDateS", query = "SELECT s FROM SalesBill s WHERE s.dateS = :dateS")
    , @NamedQuery(name = "SalesBill.findBySourceS", query = "SELECT s FROM SalesBill s WHERE s.sourceS = :sourceS")
    , @NamedQuery(name = "SalesBill.findByBillTableId", query = "SELECT s FROM SalesBill s WHERE s.billTableId = :billTableId")
    , @NamedQuery(name = "SalesBill.findByVlaue", query = "SELECT s FROM SalesBill s WHERE s.vlaue = :vlaue")})
public class SalesBill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "S_ID")
    private Integer sId;
    @Column(name = "DATE_S")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateS;
    @Column(name = "SOURCE_S")
    private String sourceS;
    @Column(name = "BILL_TABLE_ID")
    private Integer billTableId;
    @Column(name = "VLAUE")
    private Integer vlaue;

    public SalesBill() {
    }

    public SalesBill(Integer sId) {
        this.sId = sId;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public Date getDateS() {
        return dateS;
    }

    public void setDateS(Date dateS) {
        this.dateS = dateS;
    }

    public String getSourceS() {
        return sourceS;
    }

    public void setSourceS(String sourceS) {
        this.sourceS = sourceS;
    }

    public Integer getBillTableId() {
        return billTableId;
    }

    public void setBillTableId(Integer billTableId) {
        this.billTableId = billTableId;
    }

    public Integer getVlaue() {
        return vlaue;
    }

    public void setVlaue(Integer vlaue) {
        this.vlaue = vlaue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesBill)) {
            return false;
        }
        SalesBill other = (SalesBill) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd_project.SalesBill[ sId=" + sId + " ]";
    }
    
}
