<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="styles/shared.css">
        <jsp:include page="header.jsp"/>
        <article style="width: 90%;">
             <div  style="text-align: center;margin-top: 30px;">       
                  <form method="post" action="survey.jsp">
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;">PARTICIPATE IN A SURVEY</button>  
            </form>
<!--                <p> <a href="votezController?action=listofcandidates">CLICK HERE TO SEE THE CANDIDATE DETAILS</a> </p>-->
        <div  style="text-align: center;margin-top: 30px;"> 
        <form method="post" action=votezController?action=listofcandidates>
        <button type="submit" class="btn btn-primary" style="width: 30%; margin-left: auto;margin-right: auto;">CLICK TO SEE THE CANDIDATE DETAILS</button>
        </div>
        </form>
            <div  style="text-align: center;margin-top: 30px;">                
                <form method="post" action="votenow.jsp">
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> CLICK HERE TO VOTE NOW</button>  
            </form>
            </div>
            
              <div  style="text-align: center;margin-top: 30px;"> 
                <form method="post" action=votezController?action=myvotehistory>
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> CHECK MY VOTE HISTORY</button>  
            </form>
<!--                <p> <a href="votezController?action=myvotehistory">CHECK MY VOTE HISTORY</a> </p>-->
            </div>
              <div  style="text-align: center;margin-top: 30px;">                
                <p></p>
             
            </div>
             <div  style="text-align: center;margin-top: 30px;">
            <form method="post" action="peviousyearresults.jsp">
                 <button type="submit" class="btn btn-primary" style="width: 25%; margin-left: auto;margin-right: auto;"> PREVIOUS RESULTS</button>  
            </form>
             </div>
             <div  style="text-align: center;margin-top: 30px;">
            <form method="post" action=votezController?action=prediction>
                 <button type="submit" class="btn btn-primary" style="width: 30%; margin-left: auto;margin-right: auto;"> 2015 SENATE ELECTION PREDICTION RESULTS </button>  
            </form>
             </div>
            
            <br><br><br><br><br> 
        </article>
       <jsp:include page="footer.jsp"/>