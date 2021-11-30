/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author data base
 */
@Entity
@Table(name = "EXPENSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenses.findAll", query = "SELECT e FROM Expenses e")
    , @NamedQuery(name = "Expenses.findByEId", query = "SELECT e FROM Expenses e WHERE e.eId = :eId")
    , @NamedQuery(name = "Expenses.findByVlaue", query = "SELECT e FROM Expenses e WHERE e.vlaue = :vlaue")
    , @NamedQuery(name = "Expenses.findByPaidFor", query = "SELECT e FROM Expenses e WHERE e.paidFor = :paidFor")})
public class Expenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "E_ID")
    private Integer eId;
    @Column(name = "VLAUE")
    private Integer vlaue;
    @Column(name = "PAID_FOR")
    private String paidFor;

    public Expenses() {
    }

    public Expenses(Integer eId) {
        this.eId = eId;
    }

    public Integer getEId() {
        return eId;
    }

    public void setEId(Integer eId) {
        this.eId = eId;
    }

    public Integer getVlaue() {
        return vlaue;
    }

    public void setVlaue(Integer vlaue) {
        this.vlaue = vlaue;
    }

    public String getPaidFor() {
        return paidFor;
    }

    public void setPaidFor(String paidFor) {
        this.paidFor = paidFor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eId != null ? eId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.eId == null && other.eId != null) || (this.eId != null && !this.eId.equals(other.eId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bd_project.Expenses[ eId=" + eId + " ]";
    }
    
}
