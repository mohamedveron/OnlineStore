package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ESC
 */
@Entity
@Table(name = "address")
public class AddressBean {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String address;
    @ManyToOne
    private CustomerBean customer;

   public AddressBean(){
       
   }
   
   

   public AddressBean(int Id,String address,CustomerBean customer){
       this.Id = Id;
       this.address = address;
       this.customer = customer;
       
   }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}