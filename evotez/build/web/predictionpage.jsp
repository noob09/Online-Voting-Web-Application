<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Studies</title>
        <jsp:include page="adminheader.jsp"/>
         <link rel="stylesheet" type="text/css" href="styles/login.css">
        
  
            <div class="form-group">
                  <label for="pwd">PREDICTION</label>
            </div>
     
        
        <aside>           
            <p></p>
            <a href="adminpage.jsp">
            &lt;&lt;Return to Main page
        </a>
        </aside>
        
        <article class="rootContent" style="width: 80%;margin-left: auto;margin-right: auto;">
            
            <div class="table-responsive" >
                <div class="container" style="width: 80%">
                         
                <table class="table-striped table">
                  <thead>
                    <tr>
                      <th style='width: 22%;'>Party Code</th>
                      <th style='width: 22%;'>Winning %</th>
                  
                    </tr>
                  </thead>
                  
                  <tbody>
                    <c:forEach var="prediction" items="${predictionresults}">
                        <tr>
                            <td> 
                                <c:out  value="${prediction.partyName}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${prediction.winningChance}" ></c:out>
                            </td>
                                                      
                        </tr>
                    </c:forEach>
                      
                   </tbody>
                </table>
              </div>

          </div>
       
        </article>
        <jsp:include page="footer.jsp"/>
   