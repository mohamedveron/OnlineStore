/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ESC
 */
@Entity
@Table(name= "customer")  
public class CustomerBean extends UserBean {
    
    private String email;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})    
    private List<AddressBean>addresses = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "customer_products")
    private List<ProductBean>products = new ArrayList<>();

    //Constructors
	public CustomerBean(){
		super();
                //this.products = new ArrayList<>();
	}
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }

    public List<AddressBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressBean> addresses) {
        this.addresses = addresses;
    }
    
    public void addProduct(ProductBean p){
        this.products.add(p);
    }
    
    public void addAddress(AddressBean address){
     this.addresses.add(address);
     address.setCustomer(this);
    }
    
}
