/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CategoryBean;
import Model.ProductBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author ESC
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

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
        String exception = "";
        String name = "";
        double price = 0;
        int quantity = 0;
        ServletContext context = request.getServletContext();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(500000);
		//FileUpload upload = new FileUpload(factory);
                ServletFileUpload upload = new ServletFileUpload(factory);
                    // maximum file size to be uploaded.
                    upload.setSizeMax( 4 * 1024 );

                
		Map<String, String> fields = new HashMap<String, String>();
		
                        boolean check  = ServletFileUpload.isMultipartContent(request); 
                         if( !check ){
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Servlet upload</title>");  
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<p>No file uploaded</p>"); 
                                out.println("</body>");
                                out.println("</html>");
                                return;
                             }
                            System.out.println("henaaaaaaaaaaaaaaaaaa...." + fields.size());
			List<FileItem> items = upload.parseRequest((RequestContext) request);
			FileItem file = null;
                         System.out.println("henaaaaaaaaaaaaaaaaaa");
			for(FileItem item : items){
				if(item.isFormField()){
					fields.put(item.getFieldName(), item.getString());
				}
				else{
					file = item;
				}
			}
			if(file == null){
                            System.out.println("henaaaaaaaaaaaaaaaaaa");
				exception = Globals.FILE_PROBLEM;
			}
			else{
				name = fields.get("modelName");
				String p = fields.get("price");
                                String q = fields.get("quantity");
				price = Double.parseDouble(p);
                                quantity = Integer.parseInt(q);
				}
					String firstPathPart = context.getRealPath("") + "/";
					String secondPathPart = "images"
							+ "/" +  file.getName();
					FileUtilities.saveFile(firstPathPart + secondPathPart, file.getInputStream());
                                        ProductBean product = new ProductBean(name, secondPathPart, quantity, price, new ArrayList<CategoryBean>());
					
					exception = Globals.SUCCESS;
					

        } catch (Exception ex) {
            exception = "cant not save";
        }
        
        System.out.println("error is" + exception);
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
