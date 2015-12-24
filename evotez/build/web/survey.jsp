

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <jsp:include page="header.jsp"/>
        <aside>           
            <h4>  <div  style="text-align: center;margin-top: 30px;">
               Welcome to the Survey of the Current Election!!! 
            </div>
            </h4>
            
      
        </aside>
             <aside>           
            <p></p>
            <a href="main.jsp">
            &lt;&lt;Return to Main page
        </a>
        </aside>
        <article class="rootContent">
            <form method="post" action="votezController">
                     <input type="hidden" name="action" value="survey">
                  <div  style="width: 20%; margin-left: auto;margin-right: auto;">
                <h4>who do you think will win 2015 senate election</h4>
                 </div>
                <div  style="width: 15%; margin-left: auto;margin-right: auto;">
                <input type="radio" name="senate" value="DEM"> DEM </input>
                  </div>
                     <div  style="width: 15%; margin-left: auto;margin-right: auto;">
                <input type="radio" name="senate" value="REP"> REP</input>
                  </div>
                <div  style="width: 15%; margin-left: auto;margin-right: auto;">
                <input type="radio" name="senate" value="UNA"> UNA</input>
                </div>
                  <div  style="width: 15%; margin-left: auto;margin-right: auto;">
                <input type="submit" class="btn btn-primary" value="Submit">
                 </div>
            </form>
            <div  style="width: 50%; margin-left: auto;margin-right: auto;">
    <h4>Note:</h4><div><p>if the user will submit the survey results without any input,that result will not be 
            taken into consideration  </p></div>  </div>
        </article>
    
        <jsp:include page="footer.jsp"/>
      

