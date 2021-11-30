/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author data base
 */
@Entity
  
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCusId", query = "SELECT c FROM Customer c WHERE c.cusId = :cusId")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByAddress", query = "SELECT c FROM Customer c WHERE c.address = :address")})
public class Customer implements Serializable {
 
    @Column(name = "STORE_TYPE")
    private String storeType;
    private static final long serialVersionUID = 1L;
    @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUS_ID")
    @SequenceGenerator(sequenceName = "CUS_ID " ,allocationSize = 1 ,name ="CUS_ID" )

    @Basic(optional = false)
    @Column(name = "CUS_ID")
    private Long cusId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @JoinTable(name = "BUY", joinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUS_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRO_ID")})
    @ManyToMany
    private Collection<Product> productCollection;
    @JoinColumn(name = "SALES_MAN_ID", referencedColumnName = "SM_ID")
    @ManyToOne
    private Salesman salesManId;

  // (name ="BUY",joinColumns={@JoinColumn(name = "CUS_ID")})
  
   public Customer() {
    }

    public Customer(Long cusId) {
        this.cusId = cusId;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Salesman getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(Salesman salesManId) {
        this.salesManId = salesManId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusId != null ? cusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.cusId == null && other.cusId != null) || (this.cusId != null && !this.cusId.equals(other.cusId))) {
            return false;
        }
        return true;
    }
    public String toString(){
        String a;
        a= String.valueOf(this.getCusId());
       // b= String.valueOf(this.getCusId());
            return a+ "     "+name+"     "+storeType+"     "+address+"     "+getSalesManId().getSmId();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }
    
}
