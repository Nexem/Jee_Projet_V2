package Utils;

public class constants {
    
    public static final String QUERYEMPLOYEES = "SELECT * from EMPLOYEES";
    public static final String QUERYUSER = "SELECT * from LISTUSERS";
    public static final String QUERY_DELETE_EMPLOYEE_ID = "DELETE FROM EMPLOYEES WHERE ID = ";
    public static final String QUERY_UPDATE_EMPLOYEE_ID = "UPDATE EMPLOYEES SET ";
    public static final String QUERY_UPDATE_END_EMPLOYEE_ID = " WHERE ID = ";
    public static final String QUERY_DETAILS_ID = "SELECT * FROM EMPLOYEES WHERE ID = ";
    public static final String QUERY_INSERT = "INSERT INTO EMPLOYEES (NAME, FIRSTNAME, HOME_PHONE, MOBILE_PHONE, WORK_PHONE, ADDRESS, POSTAL_CODE, CITY, EMAIL) VALUES (";
    
    public static final String MAINPAGE = "WEB-INF/mainpage.jsp";
    public static final String LOGINPAGE = "WEB-INF/login.jsp";
    public static final String ADDPAGE = "WEB-INF/add.jsp";
    public static final String DETAILSPAGE = "WEB-INF/details.jsp";
    public static final String GOODBYEPAGE = "WEB-INF/goodbye.jsp";
    public static final String PROPERTIES_FILE="Utils/db.properties";
    
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PWD = "dbPwd";
}
