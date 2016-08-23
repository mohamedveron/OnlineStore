/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.OrderBean;
import Model.Order_Products;
import Model.ProductBean;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author test
 */
public class OrderDAO {
    
    public static void addOrder(OrderBean order){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        
           }
    
    public static void addOrder_product(OrderBean order, ProductBean product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Order_Products products = new Order_Products();
        products.setDate(new Date());
        products.setOrder(order);
        products.setProduct(product);
        products.setProduct_price(product.getPrice());
        order.getProducts().add(products);
        session.save(products);
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }
    
    
    public static void updatePrice(OrderBean order){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
        session.close();
    }
    
    public static List<Order_Products> getOrder_products(int id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql = "from Order_Products o where o.order.Id =  id  ";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }
    
    public static List<OrderBean>  getOrders(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        String hql = "from OrderBean";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }
    
}
