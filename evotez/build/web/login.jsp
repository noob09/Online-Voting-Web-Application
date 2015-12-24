<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" type="text/css" href="styles/login.css">

        <jsp:include page="header.jsp"/>
          
           <article class="rootContent">
                <p><i>${requestScope.message}</i></p>
<!--             <img src="images/vote1.jpg"  class="imagesa" alt="brand" width=20% height=10% >-->
            <form action="votezController" method="post" >
                <input type="hidden" name="action" value="login" ><br>
                
                <div class="form-group">
                  <label for="email">Email address:</label>
                  <input type="email" class="form-control" id="email" name="emailid" required>
                </div>
                <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input  type="password" class="form-control" id="password" name="password" required>
                </div>
            <button type="submit" class="btn btn-primary">LogIn</button>
            </form>
            
            
            <p> <a href="register.jsp">Register here</a> </p>
             <p> <a href="adminlogin.jsp">Admin Login</a> </p>
            
            
              
        </article>
    <jsp:include page="footer.jsp"/>