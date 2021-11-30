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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SALESMAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salesman.findAll", query = "SELECT s FROM Salesman s")
    , @NamedQuery(name = "Salesman.findBySmId", query = "SELECT s FROM Salesman s WHERE s.smId = :smId")
    , @NamedQuery(name = "Salesman.findByName", query = "SELECT s FROM Salesman s WHERE s.name = :name")
    , @NamedQuery(name = "Salesman.findByPhone", query = "SELECT s FROM Salesman s WHERE s.phone = :phone")
    , @NamedQuery(name = "Salesman.findByAdress", query = "SELECT s FROM Salesman s WHERE s.adress = :adress")
    , @NamedQuery(name = "Salesman.findByBirthday", query = "SELECT s FROM Salesman s WHERE s.birthday = :birthday")
    , @NamedQuery(name = "Salesman.findBySalary", query = "SELECT s FROM Salesman s WHERE s.salary = :salary")
    , @NamedQuery(name = "Salesman.findByPassword", query = "SELECT s FROM Salesman s WHERE s.password = :password")})
public class Salesman implements Serializable {

    @OneToMany(mappedBy = "salesManId")
    private Collection<Customer> customerCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SM_acc_ID")
    @SequenceGenerator(sequenceName = "SM_acc_ID " ,allocationSize = 1 ,name ="SM_acc_ID" )
    @Basic(optional = false)
    @Column(name = "SM_ID")
    private Long smId;
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
    @JoinColumn(name = "MANEGER_ID", referencedColumnName = "ACC_ID")
    @ManyToOne(optional = false)
    private Accountat manegerId;

    public Salesman() {
    }

    public Salesman(Long smId) {
        this.smId = smId;
    }

    public Salesman(Long smId, String name, String adress, int salary, String password) {
        this.smId = smId;
        this.name = name;
        this.adress = adress;
        this.salary = salary;
        this.password = password;
    }

    public Long getSmId() {
        return smId;
    }

    public void setSmId(Long smId) {
        this.smId = smId;
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

    public Accountat getManegerId() {
        return manegerId;
    }

    public void setManegerId(Accountat manegerId) {
        this.manegerId = manegerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smId != null ? smId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesman)) {
            return false;
        }
        Salesman other = (Salesman) object;
        if ((this.smId == null && other.smId != null) || (this.smId != null && !this.smId.equals(other.smId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return smId + "     "+name+"     "+adress+"     "+salary;
    }
    
    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }
    
}
