<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Studies</title>
        <jsp:include page="header.jsp"/>
        
        <aside>  
             <div  style="text-align: center;margin-top: 30px;">
            My Vote History 
             </div>
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
                      <th style='width: 22%;'>Registration Number</th>
                      <th style='width: 22%;'>Candidate ID</th>
                      <th>Party Name</th>
                      <th>Election Type</th>
                      <th>year</th>
                    </tr>
                  </thead>
                  
                  <tbody>

                     <c:forEach var="voter" items="${voterlist}">
                        <tr>
                            <td> 
                                <c:out  value="${voter.voterregNum}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${voter.candidate_id}" ></c:out>
                            </td>
                            <td>                            
                                <c:out  value="${voter.partyCode}" ></c:out>
                            </td>
                            <td>  
                              <c:out  value="${voter.election_type}" ></c:out>
                            </td>  
                            <td>
                               <c:out  value="${voter.year}" ></c:out>
                             </td>      
                                
                        </tr>
                    </c:forEach>
                      
                   </tbody>
                </table>
              </div>

          </div>
       
        </article>
        <jsp:include page="footer.jsp"/>
   