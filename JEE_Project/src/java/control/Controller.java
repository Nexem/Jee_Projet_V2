/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.model.DataAccess;
import jee.model.EmployeeBean;
import jee.model.User;

/**
 *
 * @author Jacques
 */
public class Controller extends HttpServlet {

    ArrayList<EmployeeBean> listEmployees;
    ArrayList<User> listUsers;
    DataAccess db;
    String queryEmployees;
    String queryUser;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //To be able to use the "session" object like we did in the JSPs
        HttpSession session = request.getSession();
        
        db = new DataAccess();
        queryEmployees = "SELECT * from EMPLOYEES";
        queryUser = "SELECT * from LISTUSERS";

        // List of employees from database
        listEmployees = db.getEmployees(
                db.getResultSet(
                        db.getStatement(
                                db.getConnection()), queryEmployees));
        
        // Store the list of employees in a scope object
        session.setAttribute("employeesList",listEmployees );

        // Credentials retrived from the database
        listUsers = db.getUsers(
                db.getResultSet(
                        db.getStatement(
                                db.getConnection()), queryUser));

        // User input
        String loginEntered = request.getParameter("loginField");
        String pwdEntered = request.getParameter("pwdField");

        //Compare credentials only if the user has entered something
        if (loginEntered != null && pwdEntered != null) {
            for (User u : listUsers) {

                if ((loginEntered.equals(u.getLogin())) && pwdEntered.equals(u.getPwd())) {
                    request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
                }
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
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
