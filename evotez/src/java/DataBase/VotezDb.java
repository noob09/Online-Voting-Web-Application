/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import BeanClass.Candidate;
import BeanClass.Prediction;
import BeanClass.VoteDetails;
import BeanClass.Votez;
import com.mysql.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author praveen_sangalad
 */
public class VotezDb {
    String path;
    String userName;
    String password;
        private static Connection connection;
    public void establishDatabaseConnection() throws ClassNotFoundException
    {
        
              try {
                 
                         path = "jdbc:mysql://localhost:3307/Votez";
                         userName = "root";
                         password = "";
                            Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(path,userName,password);
                  }
              catch (SQLException ex) {
            Logger.getLogger(VotezDb.class.getName()).log(Level.SEVERE, null, ex);                
        }
        
    }
    
    
    public int getregnum(String email) throws ClassNotFoundException{
         establishDatabaseConnection();
         int regnum=0;
         try 
        {
            PreparedStatement ps;
            String query = "SELECT * from voter_registration where email_address=?";
             ps = connection.prepareStatement(query);
             ps.setString(1, email);
             ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next())
            {
                 regnum=rs.getInt("reg_num");
              
            }
        }
        
        catch (SQLException ex) 
        {
            System.out.println("Exception" +ex);
        }
         return regnum;
    }
    
    
    public List<Candidate> currentsenateelectionresults(){
         List<Candidate> senateresults = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
           String query = "SELECT * from curent_senate_results";
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
                 Candidate candidate=new Candidate();
                 candidate.setFirstName(rset.getString("first_name"));
                 candidate.setLastName(rset.getString("last_name"));
                 candidate.setPartyCode(rset.getString("party_code"));
                 candidate.setCandidateId(rset.getInt("candidate_id"));
                 candidate.setVoteCount(rset.getInt("results"));
                 
                 senateresults.add(candidate);
                }
            }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
    return  senateresults;
       
    }
    
    
    public List<Prediction> predictresults(){
        
         List<Prediction> predictionresults = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
           String query = "SELECT * from prediction_results";
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
                 Prediction prediction=new Prediction();
                 prediction.setPartyName(rset.getString("party_code"));
                 prediction.setWinningChance(rset.getInt("winning %"));
                 predictionresults.add(prediction);
                }
            }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
    return  predictionresults;
       
    }
    
    public void addsurvey(int regisnum,String partypref){
         String preparedQuery="INSERT INTO survey(reg_num,preference)"+ "VALUES(?,?)";
            try{
            PreparedStatement ps;
           ps = connection.prepareStatement(preparedQuery);
           ps.setInt(1, regisnum);
           ps.setString(2,partypref);
           ps.executeUpdate();
    }
         catch(Exception e)
         {
             System.out.println("error" +e);
         }
    
    }
//    public void insertsurvey(int regcode,String partyname) throws ClassNotFoundException{
//        //establishDatabaseConnection();
//        String preparedQuery="INSERT INTO survey(reg_num,preference)"+ "VALUES(?,?)";
//         PreparedStatement ps;
//        try {
//         ps = connection.prepareStatement(preparedQuery);
//         ps.setInt(1,regcode);
//         ps.setString(2,partyname);
//         ps.executeUpdate();
//        }
//        catch(Exception e)
//        {
//         System.out.println("Exception"+e);
//        }
//    }
    public boolean comparessn(String ssn){
         boolean  isssnexists=false;
        try 
        {
            PreparedStatement ps;
            String query = "SELECT * from tempregistrationdb where SSN=?";
             ps = connection.prepareStatement(query);
             ps.setString(1, ssn);
             ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while(rs.next())
            {
                String newssn=rs.getString("SSN");
                if(ssn.equals(newssn)){
                isssnexists=true;
                }
            }
        }
        
        catch (SQLException ex) 
        {
            System.out.println("Exception" +ex);
        }
        return isssnexists;
        
    }
    public void insertregistrationDB() throws SQLException, ClassNotFoundException{
        
                   String ssn="";
                  int reg_num=0;
                  String firstname="";
                  String lastname="";
                  int age=0;
                   String gender="";
                    String street_address="";
                    String city="";
                     String state="";
                     int zip=0;
                     int contact=0;
                     String email="";
                     String password="";
                establishDatabaseConnection();
                Statement stmt = (Statement) connection.createStatement();
                String query = "select * from tempregistrationdb";
                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
                while(rs.next()){
                   ssn=rs.getString("SSN");
                   reg_num=rs.getInt("reg_num");
                   firstname=rs.getString("First_name");
                   lastname=rs.getString("Last_name");
                   age=rs.getInt("age");
                    gender=rs.getString("gender");
                     street_address=rs.getString("street_address");
                     city=rs.getString("city");
                      state=rs.getString("state");
                     zip=rs.getInt("zip_code");
                     contact=rs.getInt("contact");
                     email=rs.getString("email_id");
                     password=rs.getString("password");
                  }
        
        
        String preparedQuery="INSERT INTO voter_registration(SSN,reg_num,First_name,Last_name,age,gender,street_address,city,state,zip_code,contact,email_address,password)"+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try 
        {
            ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, ssn);
            ps.setInt(2, reg_num);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setInt(5, age);            
            ps.setString(6, gender);
            ps.setString(7, street_address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setInt(10, zip); 
            ps.setInt(11, contact); 
            ps.setString(12, email);
            ps.setString(13, password);
            ps.executeUpdate();
        } 
        
        catch (SQLException ex) 
        {
            System.out.println("Exception" +ex);
        }

      }   
     public List<Candidate> get2013mayorresults(){
         String query="select * from election_results_mayor";
         List<Candidate> mayorlist = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
                  Candidate candidate=new Candidate();
                  candidate.setFirstName(rset.getString("First_name"));
                  candidate.setLastName(rset.getString("Last_name"));
                  candidate.setCandidateId(rset.getInt("Candidate_id"));
                  candidate.setPartyCode(rset.getString("Party_Code"));
                  candidate.setVoteCount(rset.getInt("vote_count"));
                mayorlist.add(candidate);
                }
            
        }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
    return  mayorlist;
            
        }
     
            public List<Votez> surveyresults(){
                String query="select * from prefered_party";
         List<Votez> surveylist = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
              Votez votez=new Votez();
              votez.setPartyCode(rset.getString("prefered_party"));
               votez.setSurveyResult(rset.getInt("survey_result"));
                surveylist.add(votez);
                }
            
        }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
            return  surveylist;
       }
            
     
          public List<Candidate> get2013senateresults(){
         String query="select * from election_results_senate";
         List<Candidate> senatelist = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
                  Candidate candidate=new Candidate();
                  candidate.setFirstName(rset.getString("First_name"));
                  candidate.setLastName(rset.getString("Last_name"));
                  candidate.setCandidateId(rset.getInt("Candidate_id"));
                  candidate.setPartyCode(rset.getString("Party_Code"));
                  candidate.setVoteCount(rset.getInt("vote_count"));
                senatelist.add(candidate);
                }
            
        }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
    return  senatelist;
            
        }
    
      public void tempregistrationDB(Votez votez) throws ClassNotFoundException, SQLException{
          
          CallableStatement callablestatement=null;
        try {
            
            establishDatabaseConnection();
            callablestatement=(CallableStatement)connection.prepareCall("{call temp_registrationdb(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            callablestatement.setString(1,votez.getSsn());
            callablestatement.setInt(2,votez.getVoterregNum());
            callablestatement.setString(3, votez.getFirstName());
            callablestatement.setString(4, votez.getLastName());
            callablestatement.setInt(5, votez.getAge());
            callablestatement.setString(6, votez.getGender());
            callablestatement.setString(7, votez.getStreetAddress());
            callablestatement.setString(8, votez.getCity());
            callablestatement.setString(9, votez.getState());
            callablestatement.setInt(10, votez.getZipCode());
            callablestatement.setInt(11, votez.getContactNumber());
            callablestatement.setString(12, votez.getEmail());
             callablestatement.setString(13, votez.getPassword());
             
            
            callablestatement.execute();
           // ResultSet rs = callablestatement.getResultSet();
            
            }
    catch(Exception e){
        System.out.println("error" +e);
    }
    }
         public boolean loginCheck(String useremail, String password) throws ClassNotFoundException{
      //  String query;
        String DBuseremail, DBUserpassword;
        boolean login = false;
             CallableStatement callablestatement=null;
        try {
            establishDatabaseConnection();
            callablestatement=(CallableStatement)connection.prepareCall("{call login_checkuser(?) }");
            callablestatement.setString(1,useremail);
          //Statement stmt = (Statement) connection.createStatement();
          //query = "SELECT email_address,password from Voter_Authentication where email_address = '" + useremail +"'";
            callablestatement.execute();
            ResultSet rs = callablestatement.getResultSet();

            while(rs.next()){
                DBuseremail = rs.getString("email_address");
                DBUserpassword = rs.getString("password");

                if(DBuseremail.equals(useremail) && DBUserpassword.equals(password)){
                    System.out.println("OK");
                    login = true;
                    System.out.println(useremail + " "+ password + " " + DBuseremail + DBUserpassword);
                }
                    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
         
         public boolean adminCheck(String useremail, String password) throws ClassNotFoundException{
      //  String query;
        String DBuseremail, DBUserpassword;
        boolean login = false;
             CallableStatement callablestatement=null;
        try {
            establishDatabaseConnection();
            callablestatement=(CallableStatement)connection.prepareCall("{call admin_check(?) }");
            callablestatement.setString(1,useremail);
            callablestatement.execute();
            ResultSet rs = callablestatement.getResultSet();
            while(rs.next()){
                DBuseremail = rs.getString("email_address");
                DBUserpassword = rs.getString("password");

                if(DBuseremail.equals(useremail) && DBUserpassword.equals(password)){
                    System.out.println("OK");
                    login = true;
                    //System.out.println(useremail + " "+ password + " " + DBuseremail + DBUserpassword);
                }
                    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
            
        
    
         public boolean regnumCheck(int regnum) throws ClassNotFoundException{
             boolean isexists=false;
             // String query;
        int voter_reg_num;
             
              try {
            establishDatabaseConnection();
            Statement stmt = (Statement) connection.createStatement();
           String query = "SELECT reg_num from voter_registration where reg_num = '" + regnum +"'";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();

            while(rs.next()){
                voter_reg_num = rs.getInt("reg_num");
            
                if(voter_reg_num!=0){
                    System.out.println("OK");
                    isexists = true;
                    //System.out.println(useremail + " "+ password + " " + DBuseremail + DBUserpassword);
                }
                    
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isexists;
    }
             
         public List<Candidate> fetchlistofcandidates() throws SQLException{
             List<Candidate> listOfAllcandidates = new ArrayList<>();
             try{
              Statement stmt = (Statement) connection.createStatement();
           String query = "SELECT * from candidates_list";
            stmt.executeQuery(query);
            ResultSet rset = stmt.getResultSet();   
                while(rset.next())
                {
                  Candidate candidate=new Candidate();
                  candidate.setFirstName(rset.getString("First_name"));
                  candidate.setLastName(rset.getString("Last_name"));
                  candidate.setCandidateId(rset.getInt("Candidate_id"));
                  candidate.setLogo_id(rset.getInt("Logo_id"));
                  candidate.setPartyCode(rset.getString("Party_Code"));
                listOfAllcandidates.add(candidate);
                }
            
        }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
    return  listOfAllcandidates;
    }
   
         public List<Votez> fetchvotedetails(int reg_num) throws SQLException, ClassNotFoundException{
             
                List<Votez> voterdetails = new ArrayList<>();
             CallableStatement callablestatement=null;
            try {
            establishDatabaseConnection();
            callablestatement=(CallableStatement)connection.prepareCall("{call voter_details(?) }");
            callablestatement.setInt(1,reg_num);
            callablestatement.execute();
            ResultSet rset = callablestatement.getResultSet();
            while(rset.next())
                {
                    Votez votez=new Votez();
                    votez.setVoterregNum(rset.getInt("reg_num"));
                    votez.setCandidate_id(rset.getInt("candidate_id"));
                    votez.setPartyCode(rset.getString("party_voted"));
                    votez.setElection_type(rset.getString("election_type"));
                    votez.setYear(rset.getInt("year"));
                voterdetails.add(votez);
                }
            
        }        
        catch (SQLException ex) 
        {
            System.out.println("error"+ex);
        }         
            return  voterdetails;
             
         }
             
       public   void insert(Votez votez) {
        String preparedQuery="INSERT INTO voter_authentication(reg_num,email_address,Password)"+ "VALUES(?,?,?)";
         PreparedStatement ps;
        try {
         ps = connection.prepareStatement(preparedQuery);
         ps.setInt(1,votez.getVoterregNum());
         ps.setString(2, votez.getEmail());
         ps.setString(3, votez.getPassword());
         ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VotezDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
      
      public boolean checkuniquevoter(int regnum,String electiontype,int year) throws ClassNotFoundException{
          
       String election_type;
       int voteyear,voter_reg_num;
        boolean unqiuevoter = true;
         CallableStatement callablestatement=null;
       try {
              establishDatabaseConnection();
              callablestatement=(CallableStatement)connection.prepareCall("{call check_uniquevoter(?,?,?)}");
              callablestatement.setInt(1, year);
              callablestatement.setInt(2, regnum);
              callablestatement.setString(3, electiontype);
              callablestatement.execute();
              ResultSet rs = callablestatement.getResultSet();

            while(rs.next()){
                election_type = rs.getString("election_type");
                voteyear = rs.getInt("year");
                voter_reg_num=rs.getInt("reg_num");

                if(electiontype.equals(election_type) && regnum==voter_reg_num && year==voteyear){
                    System.out.println("OK");
                    unqiuevoter = false;
                    
                }
            }          
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unqiuevoter;
    
     } 
          
        public void insertVote(Votez votez) {
        String preparedQuery="INSERT INTO vote_details(reg_num,party_voted,candidate_id,election_type,year)"+ "VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        try {
         ps = connection.prepareStatement(preparedQuery);
         ps.setInt(1, votez.getVoterregNum());
         ps.setString(2, votez.getPartyCode());
         ps.setInt(3, votez.getCandidate_id());
         ps.setString(4, votez.getElection_type());
         ps.setInt(5, votez.getYear());
         ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VotezDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}