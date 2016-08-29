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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.json.JSONObject;

/**
 *
 * @author ESC
 */


@Entity
@Table(name = "product")
public class ProductBean {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private String image;
    private int stock;
    private double price;
    
    @ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<CustomerBean>customers;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_category")
    private List<CategoryBean>categories;
    
    @OneToMany(mappedBy = "product")
    private List<Order_Products>orders;
    
    @OneToMany(mappedBy = "basket",cascade = CascadeType.ALL)
    private List<Basket_Products>basket;

    public ProductBean(String name, String image, int quantity, double price, List<CategoryBean> categories) {
        this.name = name;
        this.image = image;
        this.stock = quantity;
        this.price = price;
        this.categories = categories;
    }
    
    

    public List<Basket_Products> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket_Products> basket) {
        this.basket = basket;
    }
    
    
    public ProductBean(){
        this.customers = new ArrayList<>();
    }

   
    public List<Order_Products> getOrders() {
        return orders;
    }

    public void setOrders(List<Order_Products> orders) {
        this.orders = orders;
    }

    public List<CategoryBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBean> categories) {
        this.categories = categories;
    }

    public List<CustomerBean> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerBean> customers) {
        this.customers = customers;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
     public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}