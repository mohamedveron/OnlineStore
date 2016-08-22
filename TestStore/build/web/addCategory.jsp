<%-- 
    Document   : addCategory
    Created on : Aug 21, 2016, 2:03:37 PM
    Author     : test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function validateForm(){
                alert('New Category has been added')
            }
            
        </script>
    </head>
    <body>
        <form class="form-horizontal" onsubmit="return validateForm()" action='AddCategoryController' method="POST">
            
   <fieldset>
    <div id="legend">
      <legend class="">AddCategory</legend>
    </div>
      <br>
    <div class="control-group">
      <!-- Username -->
      <label class="control-label"  for="Firstname">Category</label>
      <div class="controls">
        <input type="text"  name="name" placeholder="" class="input-xlarge">
        <p class="help-block">name can contain any letters or numbers, without spaces</p>
      </div>
    </div>
      <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Add Category</button>
      </div>
    </div>
        </form>
    </body>
</html>
