/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.AddressBean;
import Model.CustomerBean;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mohamed AbdEl Mohaimen 
 */

 /* add customer to database after registration */
public class CustomerDAO {
    public static void createCustomer(CustomerBean user){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //user.addAddress(new AddressBean(88,"233 st.haram"));
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    
    /* This method check if customer exists in database  */
    public static boolean findCustomer(String email,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        System.out.println(email + password);
        String hql = "from CustomerBean c where c.fName = '" + email +"' and c.password = '" + password + "' ";
        Query query = session.createQuery(hql);
        List list = query.list();
        System.out.println(list.size());
        session.close();
        if(list.size()>0)
            return false;
        else 
            return true;
}
     public static CustomerBean getCustomer(String email,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        System.out.println(email + password);
        String hql = "from CustomerBean c where c.fName = '" + email +"' and c.password = '" + password + "' ";
        Query query = session.createQuery(hql);
        List<CustomerBean> list = query.list();
        System.out.println(list.size());
        session.close();
       return list.get(0);
}
  }
