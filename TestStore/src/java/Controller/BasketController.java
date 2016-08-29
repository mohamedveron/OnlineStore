/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbAccessLayer.BasketDAO;
import DbAccessLayer.CustomerDAO;
import DbAccessLayer.ProductDAO;
import Model.BasketBean;
import Model.Basket_Products;
import Model.CustomerBean;
import Model.Product;
import Model.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author test
 */
@WebServlet(name = "BasketController", urlPatterns = {"/BasketController"})
public class BasketController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String s = request.getParameter("first");
        String type = request.getParameter("type");
       try (PrintWriter out = response.getWriter()) {
           String email = request.getSession().getAttribute("name").toString();
           String pass =  request.getSession().getAttribute("pass").toString();
           String id = request.getSession().getAttribute("basketId").toString();
         
           double total = 0;
           CustomerBean customer = CustomerDAO.getCustomer(email, pass);
           ProductBean product = ProductDAO.getProductsByName(s);
          
           BasketBean basket = BasketDAO.getBasket(id);
           
            List<Basket_Products>prods = BasketDAO.getBasket_products(id);
              
           if( BasketDAO.findBasketProducts(prods, product)!= null){
              //update product quantity 
               System.out.println("Controller.BasketController.processRequest()" + "updaaate");
              Basket_Products bprod = BasketDAO.findBasketProducts(prods, product);
              int value = 0;
              
              if(type.equals("decrease"))
              {
                     
                  if(bprod.getQuantity()>=1)
                  {
                      value = bprod.getQuantity() - 1;
                      product.setStock(product.getStock()+1);
                  } 
                  else
                      value = 0;
              }

              else if(type.equals("increase"))
              {
                  value = bprod.getQuantity() + 1;
                  product.setStock(product.getStock()-1);
              }
              
               bprod.setQuantity(value);
               BasketDAO.updateQuantity(bprod);
               ProductDAO.updateStock(product);
           }
           
           else
           {
                
                System.out.println("add new product  "+ basket.getId() + "session id " + id);
               BasketDAO.addProductToBasket(basket, product);
           }
           
           
            prods = BasketDAO.getBasket_products(id);
            List<ProductBean>products = new ArrayList<>();
            request.getSession().setAttribute("products", products);
            List<Product>products1 = new ArrayList<>();
           
           for(int i=0;i<prods.size();i++)
           {
               ProductBean pro = prods.get(i).getProduct();
               total += pro.getPrice()*prods.get(i).getQuantity();
               products.add(pro);
               products1.add(new Product(pro.getId(), pro.getName(), pro.getImage(), prods.get(i).getQuantity(), pro.getPrice()));
           }
                        
            JSONObject json = new JSONObject();
            json.put("products", products1);
            json.put("total", total);
            System.out.println(json.toString());
            out.print(json);

        } catch (JSONException ex) {
            System.out.println(Globals.PARSING_ERROR);
        } 
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
