package jee.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                employee.setHomePhone(rs.getString("HOME_PHONE"));
                employee.setMobilePhone(rs.getString("MOBILE_PHONE"));
                employee.setWorkPhone(rs.getString("WORK_PHONE"));
                employee.setAddress(rs.getString("ADDRESS"));
                employee.setPostalCode(rs.getString("POSTAL_CODE"));
                employee.setCity(rs.getString("CITY"));
                employee.setEmail(rs.getString("EMAIL"));
                employeesList.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return employeesList;
    }
    
    public EmployeeBean getEmployee(ResultSet rs) {
        EmployeeBean employee = new EmployeeBean();
        try {
            while (rs.next()) {
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setName(rs.getString("NAME"));
                employee.setHomePhone(rs.getString("HOME_PHONE"));
                employee.setMobilePhone(rs.getString("MOBILE_PHONE"));
                employee.setWorkPhone(rs.getString("WORK_PHONE"));
                employee.setAddress(rs.getString("ADDRESS"));
                employee.setPostalCode(rs.getString("POSTAL_CODE"));
                employee.setCity(rs.getString("CITY"));
                employee.setEmail(rs.getString("EMAIL"));
                employeesList.add(employee);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return employee;
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
                u.setPwd(rs.getString("PASSWORD"));
                usersList.add(u);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return usersList;
    }

}
