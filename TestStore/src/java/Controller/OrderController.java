/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbAccessLayer.AdminDAO;
import DbAccessLayer.OrderDAO;
import Model.OrderBean;
import Model.Order_Products;
import Model.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author test
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
        List<ProductBean> products = (List<ProductBean>)request.getSession().getAttribute("products");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            OrderBean order = new OrderBean();
            order.setAddress("323 st. haram");
            order.setProducts(new ArrayList<Order_Products>());
            order.setAdmin(AdminDAO.getAdmin("ahmed", "123"));
            double sum = 0;
             for(int i=0;i<products.size();i++)
                 sum += products.get(i).getPrice() * products.get(i).getStock();
             
            order.setTotalCost(sum);
            order.setDate(new Date());
            order.setStatus("pending");
            OrderDAO.addOrder(order);
            for(int i=0;i<products.size();i++){
               OrderDAO.addOrder_product(order, products.get(i));
            }
            
            List<Order_Products>oProducts = order.getProducts();
            request.setAttribute("products",oProducts);
            request.setAttribute("total", sum);
            RequestDispatcher request1 = getServletContext().getRequestDispatcher("/CustomerOrder.jsp");
            request1.forward(request, response);
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
