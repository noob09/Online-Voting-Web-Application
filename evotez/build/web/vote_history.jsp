<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <jsp:include page="header.jsp"/>
        
             
             
        
        <aside>
            
            <p></p>
            <a href="main.jsp">
            &lt;&lt;Return to Home page
        </a>
        </aside>
        
        <article class="rootContent" style="width: 80%;margin-left: auto;margin-right: auto;">
            
            <div class="table-responsive" >
                <div class="container" style="width: 80%">
                         
                <table class="table-striped table">
                  <thead>
                    <tr>
                      <th style='width: 22%;'>Registration Number</th>
                      <th style='width: 22%;'>party Voted</th>
                      <th>Candidate ID</th>
                      <th>election Type</th>
                      <th>Year</th>
                    </tr>
                  </thead>
                  
                  <tbody>

                     <c:forEach var="candidate" items="${candidateslist}">
                        <tr>
                            <td> 
                                <c:out  value="${candidate.firstName}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${candidate.lastName}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${candidate.candidateId}" ></c:out>
                            </td>
                            <td>  
                              <c:out  value="${candidate.partyCode}" ></c:out>
                            </td>  
                            <td>
                               <c:out  value="${candidate.logo_id}" ></c:out>
                             </td>      
                                
                        </tr>
                    </c:forEach>
                      
                   </tbody>
                </table>
              </div>

          </div>
       
        </article>
        <jsp:include page="footer.jsp"/>
   