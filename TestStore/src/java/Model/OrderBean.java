/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ESC
 */
@Entity
@Table (name = "orders")
public class OrderBean {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String address;
    private Date date;
    private String status;
    private double totalCost;
    
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<Order_Products>products;
    
    @ManyToOne
    private AdminBean admin;
  
    public AdminBean getAdmin() {
        return admin;
    }

    public void setAdmin(AdminBean admin) {
        this.admin = admin;
    }

    public List<Order_Products> getProducts() {
        return products;
    }

    public void setProducts(List<Order_Products> products) {
        this.products = products;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
}