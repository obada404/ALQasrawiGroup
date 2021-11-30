/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_project;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.ManyToMany;
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
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProId", query = "SELECT p FROM Product p WHERE p.proId = :proId")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByCompanyName", query = "SELECT p FROM Product p WHERE p.companyName = :companyName")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByAvailable", query = "SELECT p FROM Product p WHERE p.available = :available")})
public class Product implements Serializable {
// @ElementCollection
// @Column(name = "CUSTOMER_ID")
// @CollectionTable(name ="BUY",joinColumns={@JoinColumn(name = "CUS_ID")})
//  private Customer cus=new Customer();
//
//    public Customer getCus() {
//        return cus;
//    }
//
//    public void setCus(Customer cus) {
//        this.cus = cus;
//    }
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PRODUCT_ID")
    @SequenceGenerator(sequenceName = "PRODUCT_ID " ,allocationSize = 1 ,name ="PRODUCT_ID" )
    @Basic(optional = false)
    @Column(name = "PRO_ID")
    private BigDecimal proId;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @Column(name = "AVAILABLE")
    private short available;
    @ManyToMany(mappedBy = "productCollection")
    private Collection<Customer> customerCollection;

    public Product() {
    }

    public Product(BigDecimal proId) {
        this.proId = proId;
    }

    public Product(BigDecimal proId, String name, int price, short available) {
        this.proId = proId;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public BigDecimal getProId() {
        return proId;
    }

    public void setProId(BigDecimal proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public short getAvailable() {
        return available;
    }

    public void setAvailable(short available) {
        this.available = available;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        String string=proId + "     "+name+ "     "+price+ "     "+available;
    
        return string;
    }
    
}

