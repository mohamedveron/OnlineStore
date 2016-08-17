/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBlayer;

import Model.CustomerBean;
import org.hibernate.Session;

/**
 *
 * @author ESC
 */
public class CustomerDAO {
    public static void createCustomer(CustomerBean user){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
