/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jacques
 */
public class DataAccess {

    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    private String dbUrl;
    private String user;
    private String pwd;
    private ArrayList<EmployeeBean> employeesList;
    private ArrayList<User> usersList;

    public Connection getConnection() {
        dbUrl = "jdbc:derby://localhost:1527/PROJET";
        user = "adm";
        pwd = "adm";
        try {

            dbConn = DriverManager.getConnection(dbUrl, user, pwd);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return dbConn;
    }

    public Statement getStatement(Connection dbConn) {
        try {
            stmt = dbConn.createStatement();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return stmt;

    }

    public ResultSet getResultSet(Statement stmt, String query) {

        try {
            rs = stmt.executeQuery(query);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        }
        return rs;

    }

    public ArrayList getEmployees(ResultSet rs) {
        employeesList = new ArrayList<EmployeeBean>();
        try {
            while (rs.next()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setName(rs.getString("NAME"));
                employeesList.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return employeesList;
    }

    public String showEmployees(ArrayList<EmployeeBean> employeesList) {
           String output = "";
        for (EmployeeBean empl : employeesList) {
            output = output + empl.getFirstName() + "  -  "+empl.getName() + "<br/>";
        }
        
        return output;

    }
    
        public ArrayList getUsers(ResultSet rs) {
        usersList = new ArrayList<User>();
        try {
            while (rs.next()) {
                User u = new User();
                u.setLogin(rs.getString("LOGIN"));
                u.setPwd(rs.getString("PWD"));
                usersList.add(u);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return usersList;
    }

}
