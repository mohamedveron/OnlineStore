/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBlayer;

import org.hibernate.Session;
import Model.ProductBean;

/**
 *
 * @author ESC
 */
public class ProductDAO {
    public static void addProduct(){
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ProductBean product = new ProductBean();
        product.setImage("/js");
        product.setName("jeans");
        product.setQuantity(3);
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }
}
