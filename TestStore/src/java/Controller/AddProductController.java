/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
		
		/*DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(500000);
		FileUpload upload = new FileUpload(factory);
		Map<String, String> fields = new HashMap<String, String>();
		try {
			List<FileItem> items = upload.parseRequest(request);
			FileItem file = null;
			for(FileItem item : items){
				if(item.isFormField()){
					fields.put(item.getFieldName(), item.getString());
				}
				else{
					file = item;
				}
			}
			if(file == null){
				return Globals.FILE_PROBLEM;
			}
			else{
				String color = fields.get("color");
				String modelName = fields.get("modelName");
				int convertable = Integer.parseInt(fields.get("convertable"));
				String brandName = fields.get("brand");
				String shape = fields.get("shape");
				int type = Integer.parseInt(fields.get("type"));
				String material = fields.get("material");
				double price = Double.parseDouble(fields.get("price"));
				Brand brand = BrandDAO.getBrandByName(brandName);
				if(brand == null){
					return Globals.BRAND_NOT_EXIST;
				}
				if(GlassesDAO.getGlassesByModelName(modelName) == null){
					String firstPathPart = context.getRealPath("") + "/";
					String secondPathPart = "Glasses"
							+ "/" + brandName + "/" + file.getName();
					FileUtilities.saveFile(firstPathPart + secondPathPart, file.getInputStream());
					Glasses glasses = new Glasses(color, modelName, secondPathPart, convertable, shape, type, material, price, brand);
					GlassesDAO.addGlasses(glasses);
					return Globals.SUCCESS;
				}
				else{
					return Globals.ALREADY_EXIST;
				}
			}
		} catch (Exception e) {
			return Globals.FILE_PROBLEM;
		}
	}
        }*/
    }

    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
