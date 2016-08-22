/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.AdminBean;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author test
 */
public class AdminDAO {

    public static void createAdmin(AdminBean user){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
    
    /* This method check if customer exists in database  */
    public static boolean findAdmin(String handle,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql = "from AdminBean a where a.fName = '" + handle +"' and a.password = '" + password + "' ";
        Query query = session.createQuery(hql);
        List list = query.list();
        System.out.println(list.size());
        session.close();
        if(list.size()>0)
            return false;
        else 
            return true;
}
    
    public static AdminBean getAdmin(String handle,String password){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql = "from AdminBean a where a.fName = '" + handle +"' and a.password = '" + password + "' ";
        Query query = session.createQuery(hql);
        List<AdminBean> list = query.list();
        System.out.println(list.size());
        session.close();
        
       return list.get(0);
}
    
}
