/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BeanClass.Admin;
import BeanClass.Prediction;
import BeanClass.Candidate;
import BeanClass.VoteDetails;
import BeanClass.Votez;
import DataBase.VotezDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author praveen_sangalad
 */
@WebServlet(name = "votezController", urlPatterns = {"/votezController"})
public class votezController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("action");
       
        VotezDb votezdb=new VotezDb();
         HttpSession session=request.getSession();
        //String receiverEmail=request.getParameter("registeremail");
        
          if("login".equals(action) )
        {                        
            String loginemail = request.getParameter("emailid");
            String loginpassword = request.getParameter("password");
                                   
                                    
            if(votezdb.loginCheck(loginemail, loginpassword))
            {            
                Votez votez=new Votez();
                votez.setEmail(loginemail);
                votez.setPassword(loginpassword);
                int regnum=votezdb.getregnum(loginemail);
                votez.setVoterregNum(regnum);
                session.setAttribute("votez", votez);
                request.getRequestDispatcher("/main.jsp").forward(request, response); 
                return;                                  
            }
            else
            {
                String message="invalid Credentials!!";
                request.setAttribute("message", message);
                session.setAttribute("userAuthenticated", false);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }
        }
          
          if(action.equals("survey")){
              votezdb.establishDatabaseConnection();
              String partyname=request.getParameter("senate");
              Votez votez=(Votez) session.getAttribute("votez");
           int regnum=votez.getVoterregNum();
              votezdb.addsurvey(regnum,partyname);
              request.getRequestDispatcher("/main.jsp").forward(request, response);
                return;
              
           }
          
          if(action.equals("prediction")){
              votezdb.establishDatabaseConnection();
             List<Prediction> predictionresults= votezdb.predictresults();
             request.setAttribute("predictionresults", predictionresults);
              request.getRequestDispatcher("/predictionpage.jsp").forward(request, response);
                return;
              
           }
          
                    if(action.equals("senateelectionresults")){
              votezdb.establishDatabaseConnection();
             List<Candidate> currentsenateresults= votezdb.currentsenateelectionresults();
             request.setAttribute("currentsenateresults", currentsenateresults);
              request.getRequestDispatcher("/currentsenateresults.jsp").forward(request, response);
                return;
              
           }
                  
          
          if(action.equals("listofcandidates")){
                 votezdb.establishDatabaseConnection();
                
              List<Candidate>candidatelist=votezdb.fetchlistofcandidates();
              request.setAttribute("candidateslist", candidatelist);
               request.getRequestDispatcher("/candidatedetails.jsp").forward(request, response);
                return;
             }
            if(action.equals("myvotehistory")){
                 votezdb.establishDatabaseConnection();
                 Votez votez=(Votez) session.getAttribute("votez");
                 int reg_num=votez.getVoterregNum();
                 List<Votez>voterlist=votezdb.fetchvotedetails(reg_num);
                 request.setAttribute("voterlist", voterlist);
                 request.getRequestDispatcher("/voterdetails.jsp").forward(request, response);
                 return;
             }
          if("adminlogin".equals(action)){
              
              String loginemail = request.getParameter("emailid");
            String loginpassword = request.getParameter("password");
                                   
                                    
            if(votezdb.adminCheck(loginemail, loginpassword))
            {            
               Admin admin=new Admin();
                admin.setEmailId(loginemail);
                admin.setPassword(loginpassword);
               
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("/adminpage.jsp").forward(request, response); 
                return;                                  
            }
            else
            {
                String message="invalid Credentials!!";
                request.setAttribute("message", message);
                session.setAttribute("userAuthenticated", false);
                request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
                return;
            }
              
          }
          if("mayorvotecount".equals(action)){
               votezdb.establishDatabaseConnection(); 
             List<Candidate> mayorlist=votezdb.get2013mayorresults();
             request.setAttribute("mayorlist", mayorlist);
             request.getRequestDispatcher("/usermayorresults.jsp").forward(request, response);
                return;
             
           }
          
             if("senatevotecount".equals(action)){
               votezdb.establishDatabaseConnection(); 
             List<Candidate> senatelist=votezdb.get2013senateresults();
             request.setAttribute("senatelist", senatelist);
             request.getRequestDispatcher("/usersenateresults.jsp").forward(request, response);
                return;
             
           }
          
            if("surveyresults".equals(action)){
               votezdb.establishDatabaseConnection(); 
             List<Votez> surveylist=votezdb.surveyresults();
             request.setAttribute("surveylist", surveylist);
             request.getRequestDispatcher("/surveyresults.jsp").forward(request, response);
                return;
             
           }
          
          if("Vote".equals(action)){
                votezdb.establishDatabaseConnection(); 
                int regnum= Integer.parseInt(request.getParameter("regnum"));
                String partyname=request.getParameter("partyname");
                int candidate_id=Integer.parseInt (request.getParameter("candidateid"));
                String electionType=request.getParameter("electiontype");
                int year=Integer.parseInt(request.getParameter("year"));
       
            
          if(votezdb.regnumCheck(regnum)){
                 Votez vote=new Votez();
                vote.setVoterregNum(regnum);
                 vote.setPartyCode(partyname);
                 vote.setCandidate_id(candidate_id);
                 vote.setElection_type(electionType);
                 vote.setYear(year);
                 if(votezdb.checkuniquevoter(regnum,electionType,year)){
                 votezdb.insertVote(vote);
                 request.getRequestDispatcher("/votesuccess.jsp").forward(request, response);
                 return;
                 }
                 else{
                     String error="sorry!! you have already voted for the election";
                     request.setAttribute("votererrormessage", error);
                     request.getRequestDispatcher("/votenow.jsp").forward(request, response);
                    return;
                 }
             }
              else
             {
                String errormessage="you have not registered for voting please register before voting!!";
                request.setAttribute("errormessage", errormessage);
                request.getRequestDispatcher("/votenow.jsp").forward(request, response);
                return;
             }
        
           }
          
          if("activate".equals(action)){
              String newssn=request.getParameter("ssn");
              if(votezdb.comparessn(newssn)){
                  votezdb.insertregistrationDB();
                   request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
                  
              }
              
          }
        
        
    if("register".equals(action)){
            String ssn="";
            int age=0;
            int zipcode=0;
            int phone_no=0;
            int voterregNum=0;
          //  int bound=;
            Random random= new Random();
            voterregNum = random.nextInt();
            voterregNum = Math.abs(-voterregNum);
            votezdb.establishDatabaseConnection();  
                try{
                 age =Integer.parseInt(request.getParameter("age"));
                 //ssn=Integer.parseInt(request.getParameter("ssn"));
                 ssn= request.getParameter("ssn");
                 zipcode=Integer.parseInt(request.getParameter("zip"));
                 phone_no=Integer.parseInt(request.getParameter("contact"));
                 
      
    }catch(NumberFormatException ex){
       System.err.println("illegal input");
    }
            String userMessage="please click the link to activate account: http://localhost:8080/evotez/votezController?action=activate&ssn="+ssn;
            String receiverEmail = request.getParameter("registeremail");
            String password = request.getParameter("password");
            String confirmpassword = request.getParameter("confirmpassword");
            String firstName = request.getParameter("fname");
            String lastName = request.getParameter("lname");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String gender=request.getParameter("gender");
          
            Votez vote=new Votez();
            vote.setVoterregNum(voterregNum);
            vote.setEmail(receiverEmail);
            vote.setPassword(password);
            vote.setConfirmpassword(confirmpassword);
            vote.setContactNumber(phone_no);
            vote.setSsn(ssn);
            vote.setFirstName(firstName);
            vote.setLastName(lastName);
            vote.setAge(age);
            vote.setGender(gender);
            vote.setCity(city);
            vote.setState(state);
            vote.setZipCode(zipcode);
            vote.setStreetAddress(address);
            
            if(password.equals(confirmpassword))
            {            
                votezdb.tempregistrationDB(vote);
                // votezdb.insert(vote);
                
                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
       // Get a Properties object
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
         props.setProperty("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.auth", "true");
         props.put("mail.debug", "true");
         props.setProperty("mail.smtp.socketFactory.port", "465");
         props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.setProperty("mail.smtp.socketFactory.fallback", "false");
         props.setProperty("mail.smtp.port", "465");
         props.put("mail.store.protocol", "pop3");
         final String useremail = "dst373@gmail.com";
         final String userpassword = "India@777";
            try{
               Session sessionuser = Session.getDefaultInstance(props, 
               new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(useremail, userpassword);
                             }
                });

                // -- Create a new message --
                Message message = new MimeMessage(sessionuser);

               // -- Set the FROM and TO fields --
                message.setFrom(new InternetAddress(useremail));
                message.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(receiverEmail,false));
                message.setSubject("SMTP email Test");
                message.setText(userMessage);
                message.setSentDate(new Date());
                
                Session session_mail = sessionuser.getInstance(props,null);
                Transport transport = session_mail.getTransport("smtps");
                transport.connect ("smtp.gmail.com", 465, useremail, userpassword);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();   
                Transport.send(message);
                System.out.println("Message sent.");
                
               
            }
            catch (MessagingException e)
            { 
                System.out.println("ERROR: " + e);
            }
               
            }
            else
            {
                 String message="password and confirm password must be same";
                 request.setAttribute("message", message);
                 request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
            
           request.getRequestDispatcher("/userregistered.jsp").forward(request, response);
        }
    }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(votezController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(votezController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(votezController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(votezController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
