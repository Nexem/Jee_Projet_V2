package jee.model;

public class constants {
    
    public static final String QUERYEMPLOYEES = "SELECT * from EMPLOYEES";
    public static final String QUERYUSER = "SELECT * from LISTUSERS";
    public static final String QUERY_DELETE_USER_ID = "DELETE FROM EMPLOYEES WHERE ID = ";
    public static final String QUERY_DETAILS_ID = "SELECT * FROM EMPLOYEES WHERE ID = ";
    
    public static final String MAINPAGE = "WEB-INF/mainpage.jsp";
    public static final String LOGINPAGE = "WEB-INF/login.jsp";
    public static final String ADDPAGE = "WEB-INF/add.jsp";
    public static final String DETAILSPAGE = "WEB-INF/details.jsp";
}
