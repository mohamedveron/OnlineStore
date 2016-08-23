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
import Model.CustomerBean;
import Model.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
        System.out.println("skskhfkshfhkfhdfghdfhgbasket");
        String s = request.getParameter("first");
        System.out.println("getname"+ s);
       try (PrintWriter out = response.getWriter()) {
           String email = request.getSession().getAttribute("name").toString();
           String pass =  request.getSession().getAttribute("pass").toString();
           String id = request.getSession().getAttribute("basketId").toString();
           System.out.println("88888888888888888888.." + id);
           CustomerBean customer = CustomerDAO.getCustomer(email, pass);
           ProductBean product = ProductDAO.getProductsByName(s);
           BasketBean basket = BasketDAO.getBasket(id);
              List<ProductBean>prods = basket.getProducts();
              
           if( BasketDAO.findBasketProducts(basket.getProducts(), product)){
              //update product quantity 
               System.out.println("skskhfkshfhkfhdfghdfhgbasket"+ id + "lll  " +prods.size());
           }
           
           else
           {
               BasketDAO.addProductToBasket(basket, product);
            
           }
           Set<String>p = new TreeSet<>();
           for(int i=0;i<prods.size();i++)
               p.add(prods.get(i).getName());
           
            List<ProductBean>products = new ArrayList<>();
           Iterator iterator = p.iterator(); 
           
           while(iterator.hasNext())
               products.add(ProductDAO.getProductsByName(iterator.next().toString()));
           
                        
            JSONObject json = new JSONObject();
            json.put("products", products);
            System.out.println(json.toString());
            out.print(json);
//           request.setAttribute("products", products);
//           RequestDispatcher request1 = getServletContext().getRequestDispatcher("/showBasket.jsp");
//           request1.forward(request, response);
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
