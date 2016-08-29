package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.ProductBean;
import java.util.List;

public final class StoreHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>Shop Homepage</title>\n");
      out.write("\n");
      out.write("    <link href=\"design/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <link href=\"design/css/shop-homepage.css\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        \n");
      out.write("    function updateBasket(name){\n");
      out.write("              var xmlhttp = new XMLHttpRequest();\n");
      out.write("\t      xmlhttp.open(\"POST\",\"BasketController\",true);\n");
      out.write("\t      xmlhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("\t      xmlhttp.send(\"first=\"+ name + \"&type=decrease\");\n");
      out.write("\t      xmlhttp.onreadystatechange = function()\n");
      out.write("                {\n");
      out.write("                    if( xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                            {\n");
      out.write("                          $(\"#table tbody\").remove();\n");
      out.write("                          var json = JSON.parse(xmlhttp.responseText);\n");
      out.write("                          var products = json.products;\n");
      out.write("                          var total = json.total;\n");
      out.write("                      for (var i in products) {\n");
      out.write("                        var trHTML = '';\n");
      out.write("                        trHTML += '<tr> <td>' + products[i].name + \n");
      out.write("                                '</td><td>' + products[i].price +'</td><td>' + products[i].quantity +'</td>\\n\\\n");
      out.write("                                   <td><button type=\"submit\"  name=\"first\" value=' + products[i].name + '  onclick=\"updateBasket(this.value)\"> - </button></td> </tr>';\n");
      out.write("                            $(\"#table\").append(trHTML);\n");
      out.write("\t\t\t    \n");
      out.write("\t\t\t  }\n");
      out.write("                          $(\"#total\").val(total);\n");
      out.write("                          \n");
      out.write("                            }\n");
      out.write("\t  }\n");
      out.write("          return false;\n");
      out.write("              \n");
      out.write("             \n");
      out.write("         }\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    /////////////////////////////////////////////\n");
      out.write("    \n");
      out.write("     function sendajax(name){\n");
      out.write("         \n");
      out.write("\t  var xmlhttp = new XMLHttpRequest();\n");
      out.write("\t  xmlhttp.open(\"POST\",\"BasketController\",true);\n");
      out.write("\t  xmlhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n");
      out.write("\t  xmlhttp.send(\"first=\"+ name + \"&type=increase\");\n");
      out.write("\t  xmlhttp.onreadystatechange = function()\n");
      out.write("\t  {\n");
      out.write("            if( xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("                        alert('New product added to yor basket');\n");
      out.write("                        $(\"#table tbody\").remove();\n");
      out.write("                      var json = JSON.parse(xmlhttp.responseText);\n");
      out.write("                      var products = json.products;\n");
      out.write("                      var total = json.total;\n");
      out.write("                      for (var i in products) {\n");
      out.write("                        var trHTML = '';\n");
      out.write("                        trHTML += '<tr> <td>' + products[i].name + \n");
      out.write("                                '</td><td>' + products[i].price +'</td><td>' + products[i].quantity +'</td>\\n\\\n");
      out.write("                                   <td><button type=\"submit\"  name=\"first\" value=' + products[i].name + '  onclick=\"updateBasket(this.value)\"> - </button></td> </tr>';\n");
      out.write("                            $(\"#table\").append(trHTML);\n");
      out.write("\t\t\t    \n");
      out.write("\t\t\t  }\n");
      out.write("                          $(\"#total\").val(total);\n");
      out.write("                            }\n");
      out.write("\t  }\n");
      out.write("          return false;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  </script>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Start Bootstrap</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">About</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Services</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Contact</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <!-- Page Content -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <p class=\"lead\">Shop Name</p>\n");
      out.write("                <div class=\"list-group\">\n");
      out.write("                    <a href=\"#\" class=\"list-group-item\">Category 1</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item\">Category 2</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item\">Category 3</a>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <p> Your Basket </p>\n");
      out.write("                <br>\n");
      out.write("                         <table id=\"table\" class=\"table\">\n");
      out.write("                \n");
      out.write("                                <thead>\n");
      out.write("                                  <tr>\n");
      out.write("                                    <th>Name</th>\n");
      out.write("                                    <th>price</th>\n");
      out.write("                                    <th>qut</th>\n");
      out.write("                                    <th>decrease</th>\n");
      out.write("                                  </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                </tbody>\n");
      out.write("                                </table>\n");
      out.write("                <form action=\"OrderController\" method=\"POST\">\n");
      out.write("                    Total Cost: <input type=\"text\" id=\"total\" name=\"total\" >\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"submit\" value=\"submit Order\">\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"col-md-9\">\n");
      out.write("\n");
      out.write("                <div class=\"row carousel-holder\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                            <ol class=\"carousel-indicators\">\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("                                <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n");
      out.write("                            </ol>\n");
      out.write("                            <div class=\"carousel-inner\">\n");
      out.write("                                <div class=\"item active\">\n");
      out.write("                                    <img class=\"slide-image\" src=\"images/slide1.jpg\" alt=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    <img class=\"slide-image\" src=\"images/slide1.jpg\" alt=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"item\">\n");
      out.write("                                    <img class=\"slide-image\" src=\"images/slide3.jpeg\" alt=\"\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <a class=\"left carousel-control\" href=\"#carousel-example-generic\" data-slide=\"prev\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-chevron-left\"></span>\n");
      out.write("                            </a>\n");
      out.write("                            <a class=\"right carousel-control\" href=\"#carousel-example-generic\" data-slide=\"next\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-chevron-right\"></span>\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                ");
 List<ProductBean> products = (List<ProductBean>)request.getSession().getAttribute("storeproducts");
      out.write("\n");
      out.write("                ");
 for(int i=0;i<products.size();i++){ 
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-4 col-lg-4 col-md-4\">\n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                            <img src='");
      out.print( products.get(i).getImage());
      out.write("' alt=\"\">\n");
      out.write("                            <div class=\"caption\">\n");
      out.write("                                <h4 class=\"pull-right\">");
      out.print( products.get(i).getPrice());
      out.write("</h4>\n");
      out.write("                                <h4 name=\"first\" value=\"first\"><a href=\"StoreItem.jsp\">");
      out.print( products.get(i).getName());
      out.write("</a>\n");
      out.write("                                </h4>\n");
      out.write("                                <p>See more snippets like this online store item at.</p>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" id=\"first\" name=\"first\" value='");
      out.print( products.get(i).getName());
      out.write("' onclick=\"sendajax(this.value)\" >add to cart</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        <footer>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <p>Copyright &copy; Mohamed AbdEl Mohaimen</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- /.container -->\n");
      out.write("\n");
      out.write("    <!-- jQuery -->\n");
      out.write("    <script src=\"design/js/jquery.js\"></script>\n");
      out.write("\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("    \n");
      out.write("    <!-- Bootstrap Core JavaScript -->\n");
      out.write("    <script src=\"design/js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
