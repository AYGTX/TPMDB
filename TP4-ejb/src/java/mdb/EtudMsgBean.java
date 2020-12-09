package mdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import mods.Etudiant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author AYGTX
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Q1"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EtudMsgBean implements MessageListener {

    public EtudMsgBean() {
    }

    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("Connecting to a selected database...");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            Statement st = conn.createStatement();
            String sql = "CREATE TABLE etudiant "
                    + "(nom VARCHAR(255), "
                    + " prenom VARCHAR(255), "
                    + " cin VARCHAR(255))";
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EtudMsgBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        try {
            System.out.println("Connecting to a selected database...");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            Statement st = (Statement) conn.createStatement();
            String sql = "CREATE TABLE etudiant "
                    + "(nom VARCHAR(255), "
                    + " prenom VARCHAR(255), "
                    + " cin VARCHAR(255))";
            st.executeUpdate(sql);
            st.executeUpdate("insert into etudiant values('" + e.getNom() + "','" + e.getPrenom() + "','" + e.getCin() + "')");

        } catch (Exception ex) {
            Logger.getLogger(EtudMsgBean.class.getName()).log(Level.SEVERE, null, ex);
        }
 Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
         */
    }
}
