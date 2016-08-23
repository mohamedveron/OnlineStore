<%-- 
    Document   : CustomerOrder
    Created on : Aug 21, 2016, 6:29:42 PM
    Author     : test
--%>

<%@page import="Model.Order_Products"%>
<%@page import="java.util.List"%>
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
                <% List<Order_Products> products = (List<Order_Products>)request.getAttribute("products");
                request.getSession().setAttribute("products", products); 
              double x = (Double)request.getAttribute("total"); %>
                
  <thead>
    <tr>
      <th>#</th>
      <th>Name</th>
      <th>price</th>
      <th>date</th>
    </tr>
  </thead>
  <tbody>
      <% for(int i=0;i<products.size();i++){ %>
    <tr>
      <th scope="row">1</th>
      <td> <%= products.get(i).getProduct().getName() %> </td>
      <td> <%= products.get(i).getProduct_price() %> </td>
      <td> <%= products.get(i).getDate() %> </td>
    </tr>
    <% } %>
    <tr>
      <th scope="row">Total cost is</th>
      <td> <p> <%= x %> </p> </td>
    </tr>
  </tbody>
</table>
    
    <form action="StoreHome.jsp" method="POST">
        <input type="submit" value="Go to store">
    </form>
    
</html>

