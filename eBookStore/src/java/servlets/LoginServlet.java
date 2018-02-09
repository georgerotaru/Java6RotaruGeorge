/*
 * Document : LoginServlet.java
 * Author : George
 * Copyright : George
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class implements authentication and authorization process for eBooksStore
 * java web application. Session variable "validUser" (true/false) is used to keep the value
 * of an authenticated user. The value should be true. If the variable has value false or 
 * it does not exist in session, the user is unauthorized.
 * Other session variables: "actualUser" keeps the username of the valid logged in user,
 * "actualCnp" keeps the cnp of the current user, "isAdmin" (true/false) is used to 
 * check if logged in user has administrator role and "loginError" (true/false) checks 
 * to see if valid credentials are inputed in login screen.
 * 
 * @author George
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Connects to JDBC and tests if login credentials are valid 
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        //get username and password from user input in login form
        String username = request.getParameter("authpage_username").toLowerCase();
        String password = request.getParameter("authpage_password");
        //set connection parameters to DB
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        //try to create a connection to DB and check if user exists
        try{
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement();
            String query = "SELECT * FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
            resultSet = statement.executeQuery(query);
            Boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows){
                //save as actualUser variable username
                request.getSession().setAttribute("actualUser", username);
                //save user CNP in variable actualCnp
                request.getSession().setAttribute("actualCnp", resultSet.getString("CNP"));
                //save as actualUserRole if it has administrator privileges or not
                request.getSession().setAttribute("isAdmin", resultSet.getBoolean("IS_ADMIN"));
                //create a variable to know that the user is authentificated
                request.getSession().setAttribute("validUser", true);
                //request.getSession().setAttribute("username", username);
                //delegate to jsp
                request.getRequestDispatcher("./main.jsp").forward(request, response);
            } else{
                //set validation attribute to false to be sure security will not be broken
                request.getSession().setAttribute("validUser", false);
                //establish that bad credentials were inputed
                request.setAttribute("loginError", true);
                //there is no user recorded with theese username and password so we'll stay on this page
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        } catch(SQLException ex){
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);           
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Won't be used for security reasons
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * For security purposes, this method will be invoked in login form to authenticate a user
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.removeAttribute("loginError");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Short servlet description
     * 
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes authentication and authorization process";
    }// </editor-fold>
}
