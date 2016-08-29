
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ESC
 */
@Entity
@Table(name = "basket")
public class BasketBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.EAGER)
    private List<Basket_Products>products ;
    
    @ManyToOne
    private  CustomerBean customer;

    public CustomerBean getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBean customer) {
        this.customer = customer;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public List<Basket_Products> getProducts() {
        return products;
    }

    public void setProducts(List<Basket_Products> products) {
        this.products = products;
    }
}
