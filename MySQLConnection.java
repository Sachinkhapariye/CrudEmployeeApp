/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudemp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shyam sundar
 */
public class MySQLConnection {
    static Connection connection = null;
    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empcrud", "root", "************");
            System.out.println("Connection will be done");
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(){
        if(connection != null) {
            try{
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            }
        }
    }
    
    
            
}
