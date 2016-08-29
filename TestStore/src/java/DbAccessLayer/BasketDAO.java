/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccessLayer;

import Model.BasketBean;
import Model.Basket_Products;
import Model.CustomerBean;
import Model.ProductBean;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author test
 */
public class BasketDAO {
    
    public static void addCustomerProducts(BasketBean basket,CustomerBean customer , List<Basket_Products>products){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        basket.setCustomer(customer);
        basket.setProducts(products);
        session.save(basket);
        session.getTransaction().commit();
        session.close();
    }
    
    public static BasketBean getBasket(String id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
         String hql = "from BasketBean b where b.Id = '" + id +"'  ";
        Query query = session.createQuery(hql);
        List<BasketBean> list = query.list();
        System.out.println(id); 
        System.out.println("get 2om el basket " + list.get(0).getId());
        session.close();
        return list.get(0);
        
    }
    
    public static List<Basket_Products> getBasket_products(String id){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
         String hql = "from Basket_Products b where b.basket.Id =  '" + id +"'  ";
        Query query = session.createQuery(hql);
        List<Basket_Products>list = query.list();
        System.out.println("BasketDAO.getBasket_products" + id + "size is " + list.size());
        session.close();
        return list;
    }
    
    public static void addProductToBasket(BasketBean basket , ProductBean product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Basket_Products bproduct = new Basket_Products();
        bproduct.setProduct(product);
        bproduct.setQuantity(0);
        bproduct.setBasket(basket);
        basket.getProducts().add(bproduct);
        session.save(bproduct);
        session.update(basket);
        session.getTransaction().commit();
        session.close();
    } 
    
    
     public static Basket_Products findBasketProducts(List<Basket_Products>products , ProductBean product){
        
        Basket_Products flag = null;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProduct().getName().equals(product.getName())){
                flag = products.get(i);
                break;
                
            }
        }
        
       return flag;
    }
     
     public static void updateQuantity(Basket_Products  product){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        session.close();
    }
}
