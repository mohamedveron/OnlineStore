/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.AddressBean;
import Model.CustomerBean;
import org.hibernate.Session;

/**
 *
 * @author test
 */
public class AddressDAO {
    public static void addAddress(CustomerBean customer){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        AddressBean address = new AddressBean(88,"233 st.haram",customer);
        session.save(address);
        session.getTransaction().commit();
        session.close();
    }
}
