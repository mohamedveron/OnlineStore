<%-- 
    Document   : orders
    Created on : Aug 22, 2016, 4:15:42 PM
    Author     : test
--%>

<%@page import="Model.OrderBean"%>
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
        
        <script type="text/javascript">
    
     function updateTable(id){
	  var xmlhttp = new XMLHttpRequest();
	  xmlhttp.open("POST","UpdateOrderController",true);
	  xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          var value = $( "#list" ).val();
	  xmlhttp.send("id=" + id + "&value=" + value);
          xmlhttp.onreadystatechange = function()
	  {
            if( xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                location.reload();
                          }
	  }
               return false;
  }
  </script>
  
    </head>
    <body>
            <table class="table">
                <% List<OrderBean> orders = (List<OrderBean>)request.getAttribute("orders");%>
                
  <thead>
    <tr>
      <th>#</th>
      <th>Customer address</th>
      <th>status</th>
      <th>total cost</th>
      <th> Order date </th>
      <th> Update Status </th>
    </tr>
  </thead>
  <tbody>
      <% for(int i=0;i<orders.size();i++){ %>
    <tr>
      <th scope="row">1</th>
      <td> <%= orders.get(i).getAddress() %> </td>
      <td> <%= orders.get(i).getStatus() %> </td>
      <td> <%= orders.get(i).getTotalCost() %> </td>
      <td> <%= orders.get(i).getDate() %> </td>
      <td> <select id="list">
            <option value="canceled">canceled</option>  
            <option value="delivered">delivered</option>
            <option value=" shipped"> shipped</option>
            <option value="ready for shipping"> ready for shipping</option>
            <option value="pending" selected>pending</option>
          </select> </td>
      <td> <button type="submit" id="first" name="first" value="<%= orders.get(i).getId() %>" onclick="updateTable(this.value)">update order status</button></td>
    </tr>
    <% } %>
  </tbody>
</table>
  
    </body>
     <script type="text/javascript">
    
     function update(id){
	  var xmlhttp = new XMLHttpRequest();
	  xmlhttp.open("POST","UpdateOrderController",true);
	  xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          var value = 
	  xmlhttp.send("id="+ id);
    xmlhttp.onreadystatechange = function()
	  {
            if( xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        alert('Confirm to update Order');
                        $("#table tbody").remove();
                      var json = JSON.parse(xmlhttp.responseText);
                      var orders = json.orders;
                      for (var i in orders) {
                        var trHTML = '';
                        trHTML += '<tr> <th scope="row">1</th> <td>' + orders[i].address + 
                                '</td><td>' + orders[i].status +'</td><td>' + orders[i].cost +'</td>\n\
                                <td>' + orders[i].date +' </td><td><select>
                                <option value="canceled">canceled</option>  
                                <option value="delivered">delivered</option>
                                <option value=" shipped"> shipped</option>
                                <option value="ready for shipping"> ready for shipping</option>
                                <option value="pending" selected>pending</option>
                                </select></td> <td>' + orders[i].price +'</td></tr>';
                            $("#table").append(trHTML);
			    
			  }
                            }
	  }
               return false;
  }
          
</html>
