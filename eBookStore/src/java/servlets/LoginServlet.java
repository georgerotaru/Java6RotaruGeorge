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
 * @author George
 * 
 * This servlet class implements authentication and authorization process for eBooksStore
 * java web application. Session variable "validUser" is used to keep the value
 * of an authenticated user. The value should be true. If the variable has value false or 
 * not exist in session the user is unauthorized.
 * Other session variables: "actualUser" keeps the username of the valid logged in user,
 * "isAdmin" stores true or false (if the user has administrator role or not), 
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            String query = "SELECT USERNAME, PASSWORD, IS_ADMIN FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
            resultSet = statement.executeQuery(query);
            Boolean resultSetHasRows = resultSet.next();
            if (resultSetHasRows){
                //save as actualUser variable username
                request.getSession().setAttribute("actualUser", username);
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
                request.setAttribute("loginError", true);
                //there is no user recorded with theese username and password so we'll stay on this page
                //there is no user record with theese username and password so we redirect to err page
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * Won't be used for security reasons
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * For security purposes, this method will be used to authenticate a user
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
     * This servlet computes authentication and authorization process
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes authentication and authorization process";
    }// </editor-fold>
}
