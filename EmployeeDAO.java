/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudemp.dao;

import com.mycompany.crudemp.db.MySQLConnection;
import java.util.List;
import com.mycompany.crudemp.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Shyam sundar
 */
public class EmployeeDAO {
    public static List<Employee> getAllEmployee()throws SQLException {
        List <Employee> employees = new ArrayList<>();
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from employee");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int id = rs.getInt(1);
            String firstname = rs.getString(2);
            String lasttname = rs.getString(3);
            String email = rs.getString(4);
            int salary = rs.getInt(5);
            employees.add(new Employee(id, firstname, lasttname, email, salary));
            
        }
       
        return employees;
        
    }
    
    public static int addEmployee(Employee e)throws SQLException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into employee  values(default,?,?,?,?)");
        ps.setString(1, e.getFirstname());
        ps.setString(2, e.getLastname());
        ps.setString(3, e.getEmail());
        ps.setInt(4, e.getSalary());
        
        int ans = ps.executeUpdate();
        return ans;
    }
    public static int updateEmployeeById(Employee e)throws SQLException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("update employee set firstname = ?, lastname = ?, salary = ? where emp_id = ?");
        ps.setString(1, e.getFirstname());
        ps.setString(2, e.getLastname());
       // ps.setString(3, e.getEmail());
        ps.setInt(3, e.getSalary());
        ps.setInt(4, e.getId());
        
        int ans = ps.executeUpdate();
        return ans;
    }

    public static int getAllEmployee(Employee e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void deleteEmployeeById(int EmployeeId)throws SQLException {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from employee where emp_id = ?");
        ps.setInt(1, EmployeeId);
        ps.executeUpdate(); 
        
    }
    public static Employee getAllEmployeeById(int employeeId)throws SQLException {
        Employee employee = null;
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from employee where emp_id = ?");
        ps.setInt(1, employeeId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            int id = rs.getInt(1);
            String firstname = rs.getString(2);
            String lasttname = rs.getString(3);
            String email = rs.getString(4);
            int salary = rs.getInt(5);
            employee = new Employee(id, firstname, lasttname, email, salary);
            
        }
       
        return employee;
        
    }
    
}
