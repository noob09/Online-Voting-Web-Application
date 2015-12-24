<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <jsp:include page="header.jsp"/>
        
         <div  style="width: 20%; margin-left: auto;margin-right: auto;">
             2013 Mayor Election Results
            </div>
        <aside>           
            <p></p>
            <a href="main.jsp">
            &lt;&lt;Return to Main page
        </a>
        </aside>
        
        <article class="rootContent" style="width: 80%;margin-left: auto;margin-right: auto;">
            
            <div class="table-responsive" >
                <div class="container" style="width: 80%">
                         
                <table class="table-striped table">
                  <thead>
                    <tr>
                      <th style='width: 22%;'>Candidate First Name</th>
                      <th style='width: 22%;'>Candidate Last Name</th>
                      <th>Candidate ID</th>
                      <th>Party Code</th>
                      <th>Vote Count</th>
                    </tr>
                  </thead>
                  
                  <tbody>

                     <c:forEach var="mayorlist" items="${mayorlist}">
                        <tr>
                            <td> 
                                <c:out  value="${mayorlist.firstName}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${mayorlist.lastName}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${mayorlist.candidateId}" ></c:out>
                            </td>
                            <td>  
                              <c:out  value="${mayorlist.partyCode}" ></c:out>
                            </td>  
                            <td>
                               <c:out  value="${mayorlist.voteCount}" ></c:out>
                             </td>      
                                
                        </tr>
                    </c:forEach>
                      
                   </tbody>
                </table>
              </div>

          </div>
               <div  style="text-align: center;margin-top: 30px;"> 
                   <a href="piemayor.jsp"> Click here to See the Chart View</div>
       
        </article>
        <jsp:include page="footer.jsp"/>
   