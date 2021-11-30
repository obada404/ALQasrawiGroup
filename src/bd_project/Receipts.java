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
@Table(name = "RECEIPTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receipts.findAll", query = "SELECT r FROM Receipts r")
    , @NamedQuery(name = "Receipts.findByRId", query = "SELECT r FROM Receipts r WHERE r.rId = :rId")
    , @NamedQuery(name = "Receipts.findByDateR", query = "SELECT r FROM Receipts r WHERE r.dateR = :dateR")
    , @NamedQuery(name = "Receipts.findBySourceR", query = "SELECT r FROM Receipts r WHERE r.sourceR = :sourceR")
    , @NamedQuery(name = "Receipts.findByPaymentMethod", query = "SELECT r FROM Receipts r WHERE r.paymentMethod = :paymentMethod")
    , @NamedQuery(name = "Receipts.findByCheckNumber", query = "SELECT r FROM Receipts r WHERE r.checkNumber = :checkNumber")
    , @NamedQuery(name = "Receipts.findByVlaue", query = "SELECT r FROM Receipts r WHERE r.vlaue = :vlaue")
    , @NamedQuery(name = "Receipts.findByBankName", query = "SELECT r FROM Receipts r WHERE r.bankName = :bankName")})
public class Receipts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "R_ID")
    private Long rId;
    @Column(name = "DATE_R")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateR;
    @Column(name = "SOURCE_R")
    private String sourceR;
    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;
    @Column(name = "CHECK_NUMBER")
    private Long checkNumber;
    @Column(name = "VLAUE")
    private Integer vlaue;
    @Column(name = "BANK_NAME")
    private String bankName;

    public Receipts() {
    }

    public Receipts(Long rId) {
        this.rId = rId;
    }

    public Long getRId() {
        return rId;
    }

    public void setRId(Long rId) {
        this.rId = rId;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public String getSourceR() {
        return sourceR;
    }

    public void setSourceR(String sourceR) {
        this.sourceR = sourceR;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Long checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getVlaue() {
        return vlaue;
    }

    public void setVlaue(Integer vlaue) {
        this.vlaue = vlaue;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receipts)) {
            return false;
        }
        Receipts other = (Receipts) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd_project.Receipts[ rId=" + rId + " ]";
    }
    
}
