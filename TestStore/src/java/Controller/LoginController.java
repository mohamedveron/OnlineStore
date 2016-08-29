/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbAccessLayer.AddressDAO;
import DbAccessLayer.BasketDAO;
import DbAccessLayer.CustomerDAO;
import DbAccessLayer.ProductDAO;
import Model.AddressBean;
import Model.BasketBean;
import Model.Basket_Products;
import Model.CustomerBean;
import Model.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author test
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String pass  = request.getParameter("password");
            String id = "";
            List<ProductBean>products = ProductDAO.getProducts();
            if(!CustomerDAO.findCustomer(email, pass))
            {
                 HttpSession session = request.getSession();
                 if(session.isNew()){
                     session.invalidate();
                     session = request.getSession(true);
                 }
                  
                session.setAttribute("name",email );
                session.setAttribute("pass", pass);
                CustomerBean customer = CustomerDAO.getCustomer(email, pass);
                BasketBean basket = new BasketBean();
                BasketDAO.addCustomerProducts(basket,customer, new ArrayList<Basket_Products>());
                session.setAttribute("basketId", basket.getId());
                session.setAttribute("storeproducts", products);
                //System.out.println("basket has been created" + basket.getId());
                AddressDAO.addAddress(customer);
                response.sendRedirect("StoreHome.jsp");
            
            }
            else
            {
               
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='login.html';");
                out.println("</script>");
            }
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
