/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.CategoryBean;
import org.hibernate.Session;

/**
 *
 * @author test
 */
public class CategoryDAO {
    public static void addCategory(CategoryBean category){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }
}
