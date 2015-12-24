

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" type="text/css" href="styles/login.css">
        <link rel="stylesheet" type="text/css" href="styles/shared.css">

        <jsp:include page="header.jsp"/>
        
             <aside>           
            <p></p>
            <a href="main.jsp">
            &lt;&lt;Return to Main page
        </a>
        </aside>
       
         <article class="rootContent">
             <p><i>${requestScope.message}</i></p>
            <p><i>${requestScope.errormessage}</i></p>
             <label><i>${requestScope.votererrormessage}</i></label> 
            <form method="post" action="votezController">
               
               <input type="hidden" name="action" value="Vote"><br>
                <div>
                
                    <label> Enter Your Registration Number: </label>
                    <input type="text" name="regnum" class="form-control" required >
               </div>
                <div >
                <label> Select the Party to vote </label>
                <select name="partyname" required>
                        <option name="" style="display:none">--Select the party--</option>
                        <option value="DEM">DEM</option>
                        <option value="REP">REP</option>
                        <option value="UNA">UNA</option>
                   </select>
                 </div>
                    <div >
                    <label> Select the candidate ID of the party </label>
                    <select name="candidateid" required>
                        <option name="" style="display:none">--Select the candidate ID--</option>
                        <option value="888111">888111</option>
                        <option value="888112">888112</option>
                        <option value="888113">888113</option>
                    </select>
                </div>
                  <div >
                <label> Select the election type </label>
                <select name="electiontype" required>
                        <option name="" style="display:none">--Select the election type--</option>
                        <option value="mayor">mayor</option>
                        <option value="senate">senate</option>
                       </select>
                </div>
                <div >
                <label >Year</label>
                 <select name="year">
                       <option name="year" style="display:none">2015</option>
                     </select>
               </div>
               <button type="submit" class="btn btn-primary">Vote</button>
            </form>
            <br>
                 <div  style="width: 90%; margin-left: auto;margin-right: auto;">
    <h4>Note:</h4><p>Please View the candidate details before voting  </p>  </div>
       </article>
           
        <jsp:include page="footer.jsp"/>

