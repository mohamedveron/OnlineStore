<%-- 
    Document   : StoreHome
    Created on : Aug 16, 2016, 3:28:49 PM
    Author     : test
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.ProductBean"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage</title>

    <link href="design/css/bootstrap.min.css" rel="stylesheet">

    <link href="design/css/shop-homepage.css" rel="stylesheet">
    
    <script type="text/javascript">
        
    function updateBasket(name){
        alert(name);
              var xmlhttp = new XMLHttpRequest();
	      xmlhttp.open("POST","BasketController",true);
	      xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	      xmlhttp.send("first="+ name + "&type=decrease");
	      xmlhttp.onreadystatechange = function()
                {
                    if( xmlhttp.readyState == 4 && xmlhttp.status == 200)
                            {
                          $("#table tbody").remove();
                          var json = JSON.parse(xmlhttp.responseText);
                          var products = json.products;
                      for (var i in products) {
                        var trHTML = '';
                        trHTML += '<tr> <td>' + products[i].name + 
                                '</td><td>' + products[i].price +'</td><td>' + products[i].quantity +'</td>\n\
                                   <td><button type="submit"  name="first" value=' + products[i].name + '  onclick="updateBasket(this.value)"> - </button></td> </tr>';
                            $("#table").append(trHTML);
			    
			  }
                          
                            }
	  }
          return false;
              
             
         }
    
    
    /////////////////////////////////////////////
    
     function sendajax(name){
         
	  var xmlhttp = new XMLHttpRequest();
	  xmlhttp.open("POST","BasketController",true);
	  xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	  xmlhttp.send("first="+ name + "&type=increase");
	  xmlhttp.onreadystatechange = function()
	  {
            if( xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        alert('New product added to yor basket');
                        $("#table tbody").remove();
                      var json = JSON.parse(xmlhttp.responseText);
                      var products = json.products;
                      for (var i in products) {
                        var trHTML = '';
                        trHTML += '<tr> <td>' + products[i].name + 
                                '</td><td>' + products[i].price +'</td><td>' + products[i].quantity +'</td>\n\
                                   <td><button type="submit"  name="first" value=' + products[i].name + '  onclick="updateBasket(this.value)"> - </button></td> </tr>';
                            $("#table").append(trHTML);
			    
			  }
                          
                            }
	  }
          return false;
  }
  </script>
  
</head>

<body>

    
    
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <p> Your Basket </p>
                <br>
                         <table id="table" class="table">
                
                                <thead>
                                  <tr>
                                    <th>Name</th>
                                    <th>price</th>
                                    <th>qut</th>
                                    <th>decrease</th>
                                  </tr>
                                </thead>
                                <tbody>
                                </tbody>
                                </table>
                <form action="OrderController" method="POST">
                    <input type="submit" value="submit Order">
                </form>
            </div>

            <div class="col-md-9">

                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="images/slide1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/slide1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/slide3.jpeg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>
                <div class="row">
                <% List<ProductBean> products = (List<ProductBean>)request.getSession().getAttribute("orderproducts");%>
                <% for(int i=0;i<products.size();i++){ %>
                

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src='<%= products.get(i).getImage()%>' alt="">
                            <div class="caption">
                                <h4 class="pull-right"><%= products.get(i).getPrice()%></h4>
                                <h4 name="first" value="first"><a href="StoreItem.jsp"><%= products.get(i).getName()%></a>
                                </h4>
                                <p>See more snippets like this online store item at.</p>
                                
                            </div>
                            <button type="submit" id="first" name="first" value='<%= products.get(i).getName()%>' onclick="sendajax(this.value)" >add to cart</button>
                        </div>
                    </div>
                            <% } %>
                </div>
                    
            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Mohamed AbdEl Mohaimen</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="design/js/jquery.js"></script>

    <script type="text/javascript">
        
    </script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="design/js/bootstrap.min.js"></script>
    

</body>

</html>