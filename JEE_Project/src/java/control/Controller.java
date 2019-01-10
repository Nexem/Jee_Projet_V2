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
        
        String ID = request.getParameter("ID");
        String lastname = request.getParameter("nameField");
        String  firstname = request.getParameter("prenomField");
        String  tel_dom = request.getParameter("tel_domField");
        String  tel_mob = request.getParameter("tel_mobField");
        String  tel_pro = request.getParameter("tel_proField");
        String  address = request.getParameter("adresseField");
        String  code = request.getParameter("codepostalField");
        String  town = request.getParameter("villeField");
        String  email = request.getParameter("emailField");
                
        String button = (String)request.getParameter("action");
        if(button == null)
            button = "";
        
        
        //Button management
        //To connect at the beginning, when we run the project, after the first redirection
        if(button.equals("Send"))
        {
            // Credentials retrived from the database
            listUsers = db.getUsers(db.getResultSet(db.getStatement(
                                    db.getConnection()), constants.QUERYUSER));

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
        }
        
        //Add functionalities
         else if("Add".equals(button)){
            
            request.getRequestDispatcher(constants.ADDPAGE).forward(request, response);

        }
        else if("AddEmployee".equals(button)){
            
            if ((lastname != "" && firstname != "" && tel_dom != "" && tel_pro != "" && tel_mob != "" && address != "" && email != "" && town != "" && code != "")){
                String insert_query = constants.QUERY_INSERT + "'" + lastname + "', '" + firstname + "', '" + tel_dom + "', '" + tel_mob + "', '" + tel_pro + "', '" + address + "', '" + code + "', '" + town + "', '" + email + "');";
                session.setAttribute("message",insert_query);
                db.getResultSet(db.getStatement(db.getConnection()), insert_query);
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
            else{
                session.setAttribute("message", "You must enter values in all fields");
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
        }
        else if("Cancel".equals(button)){
            request.getRequestDispatcher(constants.ADDPAGE).forward(request, response);
        }
        
        //Delete functionalities
        else if(button.equals("Delete")){
            if(request.getParameter("ID") != null){
                //String ID = request.getParameter("ID");
                String delete_query = constants.QUERY_DELETE_EMPLOYEE_ID + ID + ";";
                db.getResultSet(db.getStatement(db.getConnection()), delete_query);
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
            else{
                session.setAttribute("message", "You must select an employee");
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
        }
        
        //Buttons to access to details and cancel or register the new details
        else if(button.equals("Details")){
            if(request.getParameter("ID") != null){
                session.setAttribute("ID_user_details", request.getParameter("ID"));
                request.getRequestDispatcher(constants.DETAILSPAGE).forward(request, response);
            }
            else{
                session.setAttribute("message", "You must select an employee");
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
        }
        else if(button.equals("Save modifications")){
            if(request.getParameter("ID") != ""){ 
                String update_query = constants.QUERY_UPDATE_EMPLOYEE_ID;
                update_query += "NAME = '" + lastname;
                update_query += "', FIRSTNAME = '" + firstname;
                update_query += "', HOME_PHONE = '" + tel_dom;
                update_query += "', MOBILE_PHONE = '" + tel_mob;
                update_query += "', WORK_PHONE = '" + tel_pro;
                update_query += "', ADDRESS = '" + address;
                update_query += "', POSTAL_CODE = '" + code;
                update_query += "', CITY = '" + town;
                update_query += "', EMAIL = '" + email + "'";
                update_query += constants.QUERY_UPDATE_END_EMPLOYEE_ID + ID + ";";
                
                session.setAttribute("message", update_query);
                int i = db.getResultUpdate(db.getStatement(db.getConnection()), update_query);
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
            else{
                session.setAttribute("message", "can't save details");
                request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
            }
        }
        else if(button.equals("Cancel modifications")){
            request.getRequestDispatcher(constants.MAINPAGE).forward(request, response);
        }
        
        //Disconnection functionalities
        else if(button.equals("Goodbye")){
            request.getRequestDispatcher(constants.GOODBYEPAGE).forward(request, response);
            return;
        }
        
        else if(button.equals("GoToLogin")){
            session.invalidate();
            request.getRequestDispatcher(constants.LOGINPAGE).forward(request, response);
            return;
        }
        
        //Function to redirect first on the login page when we run the project
        else if (session.getAttribute("sessionLogin") == null){
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
