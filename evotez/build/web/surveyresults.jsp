<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Studies</title>
        <jsp:include page="header.jsp"/>
         <link rel="stylesheet" type="text/css" href="styles/login.css">
        
  
            <div class="form-group">
                  <label for="pwd">2015 SENATE SURVEY RESULTS</label>
                  
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
                      <th style='width: 22%;'>Party Name</th>
                      <th style='width: 22%;'>Survey Count</th>
                  
                    </tr>
                  </thead>
                  
                  <tbody>

                     <c:forEach var="surveylist" items="${surveylist}">
                        <tr>
                            <td> 
                                <c:out  value="${surveylist.partyCode}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${surveylist.surveyResult}" ></c:out>
                            </td>
                                                      
                        </tr>
                    </c:forEach>
                      
                   </tbody>
                </table>
              </div>

          </div>
       
        </article>
        <jsp:include page="footer.jsp"/>
   