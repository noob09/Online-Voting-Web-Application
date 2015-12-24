

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" type="text/css" href="styles/shared.css">
        <title>Login</title>
        <jsp:include page="header.jsp"/>
        <p><i>${requestScope.message}</i></p>
       
            <form method="post" action="votezController" style="width: 45%; margin-left: auto;margin-right: auto;">
               <input type="hidden" name="action" value="register"><br>
                 <label> Email ID: </label>
                 <input type="email"  name="registeremail"  id="password" required><br>
             
                <label>Password:</label>
                <input type="password" name="password"  id="password" required><br>
                
              
                <label>Confirm Password:</label>
                <input type="password" name="confirmpassword"  id="password" required><br>
                
                   <label>SSN:</label>
                <input type="text" name="ssn"  id="ssn" required><br>
                
                   <label> First name: </label>
                 <input type="text"  name="fname"  id="fname" required><br>
             
                <label>Last Name:</label>
                <input type="text" name="lname"  id="lname" required><br>
                <label>Age:</label>
                <input type="text" name="age"  id="age" required><br>
                   <label>Gender:</label>
                   <select name="gender" required> 
                        <option name="gender" style="display:none">--Select the Gender--</option>
                        <option value="MALE">MALE</option>
                        <option value="FEMALE">FEMALE</option>
                        <option value="DONT WANT TO SPECIFIY">DONT WANT TO SPECIFIY</option>
                   </select>
                   <br>
                    <label> Street Address:</label>
                <input type="text" name="address" required><br>
                    <label>City:</label>
                    <input type="text" name="city" required><br>
                    <label> State:</label>
                <input type="text" name="state" required><br>
                  
                   <label>Zip Code:</label>
                   <input type="text" name="zip" required><br>
                     <label>Contact No:</label>
                     <input type="text" name="contact" required><br><br>
              <button type="submit" class="btn btn-primary">Register Now</button>
            </form>
            <br><br><br>
    <jsp:include page="footer.jsp"/>
