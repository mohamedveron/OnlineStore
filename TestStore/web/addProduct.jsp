<%-- 
    Document   : addProduct
    Created on : Aug 22, 2016, 5:16:55 PM
    Author     : test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal" method="post" action="AddProductController" enctype="multipart/form-data">
            <fieldset>
                <div id="legend">
                  <legend class="">AddProduct</legend>
                </div>
                  <br>
                  <br></br>
                  
                <div class="control-group">
                  <!-- Username -->
                  <label class="control-label"  for="name">Product Name</label>
                  <div class="controls">
                    <input type="text"  name="name" placeholder="" class="input-xlarge">
                  </div>
                  </div>
                  <br></br>
                  
                  <div class="control-group">
                  <!-- Username -->
                  <label class="control-label"  for="price">Product price</label>
                  <div class="controls">
                    <input type="text"  name="price" placeholder="" class="input-xlarge">
                  </div>
                  </div>
                  <br></br>
                  
                  <div class="control-group">
                  <!-- Username -->
                  <label class="control-label"  for="quantity">Product quantity</label>
                  <div class="controls">
                    <input type="text"  name="quantity" placeholder="" class="input-xlarge">
                  </div>
                  </div>
                  <br></br>
                  
                  <div class="control-group">
                  <!-- Username -->
                  <label class="control-label"  for="file">Product image</label>
                  <div class="controls">
                    <input type="file"  name="file" placeholder="" class="input-xlarge">
                  </div>
                  </div>
                  <br></br>
                  <div class="control-group">
                  <div class="controls">
                    <input type="submit" value="upload" placeholder="" class="input-xlarge">
                  </div>
                  </div>
            <br></br>
            
             </fieldset>
            </form>
    </body>
</html>
