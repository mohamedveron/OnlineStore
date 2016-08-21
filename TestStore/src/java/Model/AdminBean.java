/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ESC
 */
@Entity
@Table(name= "admin") 
public class AdminBean extends UserBean {
    
    public AdminBean(){
        super();
    }
    
    @OneToMany(mappedBy = "admin")
    private List<OrderBean>orders;

    public List<OrderBean> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderBean> orders) {
        this.orders = orders;
    }
}
