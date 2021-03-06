/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.CustomerBean;
import Model.OrderBean;
import org.hibernate.Session;
import Model.ProductBean;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author ESC
 */
public class ProductDAO {
    public static void addProduct(ProductBean product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<ProductBean> getProducts(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ProductBean");
        List<ProductBean> products = query.list();
        session.close();
        for(int i=0;i<products.size();i++){
            System.err.println(products.get(i).getImage());
        }
        return products;
    }
    
    public static ProductBean getProductsByName(String name){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ProductBean p where p.name = '"+name+"'");
        List<ProductBean> products = query.list();
        session.close();
        
        return products.get(0);
    }
    
    public static ProductBean getProductsById(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from ProductBean p where p.Id = id ");
        List<ProductBean> products = query.list();
        session.close();
        
        return products.get(0);
    }
    
    public static void addCustomerProduct(CustomerBean customer,ProductBean product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        customer.getProducts().add(product);
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }
    
   public static boolean findCustomerProducts(List<ProductBean>products , ProductBean product){
        
        boolean flag = false;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getName().equals(product.getName())){
                flag = true;
                break;
            }
        }
        
        if(flag)
            return true;
        else
            return false;
    }
   
    public static void updateStock(ProductBean product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }
}
