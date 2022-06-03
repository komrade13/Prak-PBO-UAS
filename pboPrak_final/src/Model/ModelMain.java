package Model;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModelMain {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cashierizer?useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection conn;
    Statement statement;

    public ModelMain() {
        try{
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }

    public String[][] readProduct() {
        try{
            int jmlData = 0;
            
            String data[][] = new String[getDataAmount()][5]; 
            
            String query = "SELECT * FROM inventory"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("prod_id"); 
                data[jmlData][1] = resultSet.getString("prod_name");                
                data[jmlData][2] = resultSet.getString("prod_cat");
                data[jmlData][3] = resultSet.getString("prod_price");
                data[jmlData][4] = resultSet.getString("prod_quant");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertProduct(int prod_id, String prod_name, String prod_cat, int prod_price, int prod_quant) {
        try {
            int jmlData=0;
            String query = "SELECT * FROM inventory WHERE prod_id='" + prod_id+"'"; 
            System.out.println(prod_id + " " + prod_name + " " + prod_cat + " " + prod_price + " " + prod_quant);
            ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()){ 
                    jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO `inventory`(`prod_id`,`prod_name`,`prod_cat`,`prod_price`,`prod_quant`) VALUES('"+prod_id+"','"+prod_name+"','"+prod_cat+"','"+prod_price+"','"+prod_quant+"')";
           
                statement = (Statement) conn.createStatement();
                statement.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Product added");
            }
            else {
                JOptionPane.showMessageDialog(null, "Product already exists");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateProduct(int prod_id, String prod_name, String prod_cat, int prod_price, int prod_quant) {
         try {
                String query = "UPDATE inventory SET `prod_name`='" + prod_name + "',`prod_cat`='" + prod_cat + "',`prod_price` = '" + prod_price + "',`prod_quant`='"+ prod_quant+"' WHERE `prod_id`= '" + prod_id + "'" ;
                statement = (Statement) conn.createStatement();
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Product updated");
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void insertTransc(String customer_name, int total_payment) {
        try {
            String query = "INSERT INTO `transaction`(`customer_name`, `total_payment`) VALUES ('" + customer_name + "','" + total_payment + "')" ;
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Transaction Success");
        } catch (Exception sql) {
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readTransc() {
        try {
            int jmlData = 0;

            String data[][] = new String[getDataAmount2()][3]; 

            String query = "SELECT * FROM transaction"; 
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("transc_id"); 
                data[jmlData][1] = resultSet.getString("customer_name");                
                data[jmlData][2] = resultSet.getString("total_payment");
                jmlData++;
            }
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getDataAmount(){
        int jmlData = 0;
        try{
            statement = conn.createStatement();
            String query = "SELECT * FROM inventory";
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

    public int getDataAmount2(){
        int jmlData = 0;
        try{
            statement = conn.createStatement();
            String query = "SELECT * FROM transaction";
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
    
    public void deleteProduct(String prod_id) {
        try{
            String query = "DELETE FROM inventory WHERE prod_id = '"+prod_id+"'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Product deleted");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}

    