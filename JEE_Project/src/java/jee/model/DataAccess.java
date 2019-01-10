package jee.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccess {

    private Connection dbConn;
    private Statement stmt;
    private ResultSet rs;
    private String dbUrl;
    private String user;
    private String pwd;
    private ArrayList<EmployeeBean> employeesList;
    private ArrayList<User> usersList;
    private InputStream inputStream;

    public Connection getConnection() throws FileNotFoundException, IOException {
        
    
        try {
            Properties prop = new Properties();
            String propFileName = "Utils/db.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                    prop.load(inputStream);
            } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }


            dbUrl = prop.getProperty("dbUrl");
            user = prop.getProperty("user");
            pwd = prop.getProperty("pwd");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConn = DriverManager.getConnection(dbUrl, user, pwd);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int getResultUpdate(Statement stmt, String query) {
        int i;
        try {
            i = stmt.executeUpdate(query);
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            return 0;
        }
        return i;
    }

    public ArrayList getEmployees(ResultSet rs) {
        employeesList = new ArrayList<EmployeeBean>();
        try {
            while (rs.next()) {
                EmployeeBean employee = new EmployeeBean();
                employee.setID(rs.getInt("ID"));
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
                employee.setID(rs.getInt("ID"));
                employee.setFirstName(rs.getString("FIRSTNAME"));
                employee.setName(rs.getString("NAME"));
                employee.setHomePhone(rs.getString("HOME_PHONE"));
                employee.setMobilePhone(rs.getString("MOBILE_PHONE"));
                employee.setWorkPhone(rs.getString("WORK_PHONE"));
                employee.setAddress(rs.getString("ADDRESS"));
                employee.setPostalCode(rs.getString("POSTAL_CODE"));
                employee.setCity(rs.getString("CITY"));
                employee.setEmail(rs.getString("EMAIL"));
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
