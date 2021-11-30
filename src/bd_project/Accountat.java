/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author data base
 */
@Entity
@Table(name = "ACCOUNTAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accountat.findAll", query = "SELECT a FROM Accountat a")
    , @NamedQuery(name = "Accountat.findByAccId", query = "SELECT a FROM Accountat a WHERE a.accId = :accId")
    , @NamedQuery(name = "Accountat.findByName", query = "SELECT a FROM Accountat a WHERE a.name = :name")
    , @NamedQuery(name = "Accountat.findByPhone", query = "SELECT a FROM Accountat a WHERE a.phone = :phone")
    , @NamedQuery(name = "Accountat.findByAdress", query = "SELECT a FROM Accountat a WHERE a.adress = :adress")
    , @NamedQuery(name = "Accountat.findByBirthday", query = "SELECT a FROM Accountat a WHERE a.birthday = :birthday")
    , @NamedQuery(name = "Accountat.findBySalary", query = "SELECT a FROM Accountat a WHERE a.salary = :salary")
    , @NamedQuery(name = "Accountat.findByPassword", query = "SELECT a FROM Accountat a WHERE a.password = :password")})
public class Accountat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     
    @Basic(optional = false)
    @Column(name = "ACC_ID")
    private Long accId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private Long phone;
    @Basic(optional = false)
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Basic(optional = false)
    @Column(name = "SALARY")
    private int salary;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manegerId")
    private Collection<Salesman> salesmanCollection;

    public Accountat() {
    }

    public Accountat(Long accId) {
        this.accId = accId;
    }

    public Accountat(Long accId, String name, String adress, int salary, String password) {
        this.accId = accId;
        this.name = name;
        this.adress = adress;
        this.salary = salary;
        this.password = password;
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Salesman> getSalesmanCollection() {
        return salesmanCollection;
    }

    public void setSalesmanCollection(Collection<Salesman> salesmanCollection) {
        this.salesmanCollection = salesmanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountat)) {
            return false;
        }
        Accountat other = (Accountat) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name +"   "+adress+"   "+salary+"   ";
    }
    
}
//this.accId = accId;
//        this.name = name;
//        this.adress = adress;
//        this.salary = salary;
//        this.password 