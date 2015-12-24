<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="styles/shared.css">
        <jsp:include page="adminheader.jsp"/>
          <aside>           
            <p></p>
            <a href="adminpage.jsp">
            &lt;&lt;Return to Main page
        </a>
        </aside>
        <article style="width: 100%;">    
              <div  style="text-align: center;margin-top: 90px;"> 
                <form method="post" action=votezController?action=mayorvotecount>
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> 2013 MAYOR RESULTS</button>  
            </form>
            </div>
              <div  style="text-align: center;margin-top: 60px;"> 
                <form method="post" action=votezController?action=senatevotecount>
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> 2013 SENATE RESULTS</button>  
            </form>
      </div
             
           
         
            
      <br><br><br><br><br> <br><br><br><br>
        </article>
       <jsp:include page="footer.jsp"/>