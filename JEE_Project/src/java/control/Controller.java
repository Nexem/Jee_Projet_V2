package control;

import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.DataAccess;
import jee.model.EmployeeBean;
import jee.model.User;
import Utils.constants;

public class Controller extends HttpServlet {

    ArrayList<EmployeeBean> listEmployees;
    ArrayList<User> listUsers;
    DataAccess db;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        db = new DataAccess();
        
        // List of employees from database
        listEmployees = db.getEmployees(db.getResultSet(db.getStatement(
                                db.getConnection()), constants.QUERYEMPLOYEES));
        
        // Store the list of employees in a scope object
        session.setAttribute("employeesList",listEmployees );

        // Credentials retrived from the database
        listUsers = db.getUsers(db.getResultSet(db.getStatement(
                                db.getConnection()), constants.QUERYUSER));

        String OffButton = request.getParameter("OffButton");
                
        if("goodbye".equals(OffButton)){
            request.getRequestDispatcher("WEB-INF/goodbye.jsp").forward(request, response);
            return;
        }
        
        String button = request.getParameter("button");
        String id = request.getParameter("ID");
        
        while(OffButton == null){
            if(button != null ){
                if("Add".equals(button)){
                    request.getRequestDispatcher(constants.ADDPAGE).forward(request, response);
                }
                else if("Delete".equals(button)){
                    if(id != null){
                        String delete_query = constants.QUERY_DELETE_USER_ID + id;
                        db.getResultSet(db.getStatement(db.getConnection()), delete_query);
                        request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "You must select an employee1");
                        request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
                    }
                }
                else if("Details".equals(button)){
                    
                    if(id != null){
                        session.setAttribute("ID_user_details", id);
                        request.getRequestDispatcher(constants.DETAILSPAGE).forward(request, response);
                    }
                    else{
                        session.setAttribute("message", "You must select an employee2");
                        request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
                    }
                }
            }
            else{
                System.out.println(request.getParameter("button"));
                session.setAttribute("message", "else");
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
            
        }
        
        
        String loginEntered = request.getParameter("loginField");
        String pwdEntered = request.getParameter("pwdField");

        if ((loginEntered != null && pwdEntered != null)) {
            for (User u : listUsers) {
                if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPwd())) {
                    if(session.getAttribute(pwdEntered) == null && session.getAttribute(loginEntered) == null ){
                        session.setAttribute("sessionLogin", loginEntered);
                        session.setAttribute("sessionPwd", pwdEntered);
                    }
                    request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
                }
                else{
                    session.setAttribute("message", "Connection failed ! Verify your login/password and try again");
                    request.getRequestDispatcher(constants.LOGINPAGE).forward(request, response);
                }
            }
        }else if(loginEntered == "" || pwdEntered == ""){
            session.setAttribute("message", "You must enter values in both fields");
            request.getRequestDispatcher(constants.LOGINPAGE).forward(request, response);
        }
        else{
            request.getRequestDispatcher(constants.LOGINPAGE).forward(request, response);
        }
        
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
