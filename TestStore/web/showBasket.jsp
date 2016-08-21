<%-- 
    Document   : showBasket
    Created on : Aug 18, 2016, 11:51:26 AM
    Author     : test
--%>

<%@page import="java.util.List"%>
<%@page import="Model.ProductBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="design/css/bootstrap.min.css" rel="stylesheet">
         <link href="design/css/shop-homepage.css" rel="stylesheet">
          <script src="design/js/jquery.js"></script>
           <script src="design/js/bootstrap.min.js"></script>
        <title>cart basket</title>
    </head>
    <body>
            <table class="table">
                <% List<ProductBean> products = (List<ProductBean>)request.getAttribute("products"); %>
                
  <thead>
    <tr>
      <th>#</th>
      <th>Name</th>
      <th>quantity</th>
      <th>image</th>
    </tr>
  </thead>
  <tbody>
      <% for(int i=0;i<products.size();i++){ %>
    <tr>
      <th scope="row">1</th>
      <td> <%= products.get(i).getName() %> </td>
      <td> <%= "1" %> </td>
      <td> <%= products.get(i).getImage() %> </td>
    </tr>
    <% } %>
  </tbody>
</table>
    
    <form action="StoreHome.jsp" method="POST">
        <input type="submit" value="continue shopping">
    </form>
    <form action="" method="POST">
        <input type="submit" value="submit Order">
    </form>
    </body>
</html>
