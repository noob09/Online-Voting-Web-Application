<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="styles/shared.css">
        <jsp:include page="adminheader.jsp"/>
        <article style="width: 90%;">
            <br><br><br>
             <div  style="text-align: center;margin-top: 30px;">
            <form method="post" action="peviousyearresults.jsp">
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> PREVIOUS RESULTS</button>  
            </form>
             </div>
               <div  style="text-align: center;margin-top: 20px;">       
                  <form method="post" action=votezController?action=surveyresults>
                 <button type="submit" class="btn btn-primary" style="width: 30%; margin-left: auto;margin-right: auto;">2015 SENATE ELECTION SURVEY RESULTS</button>  
                  </form>    
             </div>
              <div  style="text-align: center;margin-top: 20px;">       
                  <form method="post" action=votezController?action=senateelectionresults>
                 <button type="submit" class="btn btn-primary" style="width: 30%; margin-left: auto;margin-right: auto;">2015 SENATE ELECTION  RESULTS</button>  
                  </form>    
             </div>
               <div  style="text-align: center;margin-top: 20px;">       
                  <form method="post" action=votezController?action=prediction>
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;">PREDICTION RESULTS</button>  
                  </form>    
             </div>
            <br><br><br><br><br><br>
        </article>
       <jsp:include page="footer.jsp"/>