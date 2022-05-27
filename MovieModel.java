/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExamV2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class MovieModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db?useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public MovieModel() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    
    /*public void input(String Title, double Plot, double Character, double Acting, double Score){
    int mdata=0;
        try {
           String query = "SELECT * FROM movie WHERE Title='" + Title+"'"; 
           System.out.println(Title + " " + Plot + " " + Character + " " + Acting);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                mdata++;
            }
            
            if (mdata==0) {
                query = "INSERT INTO `movie`(`Title`,`Plot`,`Character`,`Acting`,`Score`) VALUES('"+Title+"','"+Plot+"','"+Character+"','"+Acting+"','"+Score+"')";
           
                statement = (Statement) conn.createStatement();
                statement.executeUpdate(query); //execute querynya
                JOptionPane.showMessageDialog(null, "Moive added");
            }
            else {
                JOptionPane.showMessageDialog(null, "Movie already exists");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, "Insert Canceled");
        }
    }*/
    
    public String[][] readData(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getDataAmount()][5]; 
            
            String query = "SELECT * FROM movie"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Title"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("Plot"));                
                data[jmlData][2] = String.valueOf(resultSet.getDouble("Character"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("Acting"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("Score"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String Title, double Plot, double Character, double Acting, double Score){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM movie WHERE Title='" + Title+"'"; 
           System.out.println(Title + " " + Plot + " " + Character + " " + Acting);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO movie(Title,Plot,Character,Acting,Score) VALUES('"+Title+"','"+Plot+"','"+Character+"','"+Acting+"','"+Score+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Movie added");
                JOptionPane.showMessageDialog(null, "Movie Added");
            }
            else {
                JOptionPane.showMessageDialog(null, "Movie already exists");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String Title, double Plot, double Character, double Acting, double Score){
        int jmlData=0;
         try {
           String query = "SELECT * FROM movie WHERE tile='" + Title+"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE movie SET Plot='" + Plot + "', Character='" + Character + "', Score='"+ Score+"' WHERE Title='" + Title+"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Update successful");
                JOptionPane.showMessageDialog(null, "Movie updated");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Movie not found");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getDataAmount(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteData (String Title) {
        try{
            String query = "DELETE FROM movie WHERE Title = '"+Title+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Movie deleted");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
