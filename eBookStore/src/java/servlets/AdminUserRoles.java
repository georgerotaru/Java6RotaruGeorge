/*
 * Document : AdminUserRoles.java
 * Author : George
 * Copyright : George
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class implements changes made to user role in eBookStore java web
 * application (administrator or simple user).
 * @author George
 */
public class AdminUserRoles extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Connects to JDBC and changes user's role, according to specifications.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    //set connection parameters to DB
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement pstmnt = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/adminUserRoles.jsp");
        //to do if Update button pushed
        if (request.getParameter("adminuserrolepg_update")!=null){
            try{
                //connect to DB
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
                //get values from selected checkboxes in web page form
                String[] selectedCheckboxes = request.getParameterValues("adminuserrolepg__checkbox");
                //get user choice for new user role
                Boolean newrole = Boolean.parseBoolean(request.getParameter("adminuserrolepg_role"));
                //to do if new user role is administrator
                if (newrole) {
                    connection.setAutoCommit(false);
                    for(String parseUsers : selectedCheckboxes){
                        //update all selected rows
                        String myDB = "UPDATE USERS SET IS_ADMIN = ? WHERE USERNAME = ?";
                        pstmnt = connection.prepareStatement(myDB);
                        pstmnt.setBoolean(1, true);
                        pstmnt.setString(2, parseUsers);
                        boolean execute = pstmnt.execute();
                    }
                //to do if new user role is a simple user
                } else {
                    connection.setAutoCommit(false);
                    for(String parseUsers : selectedCheckboxes){
                        //update all selected rows
                        String myDB = "UPDATE USERS SET IS_ADMIN = ? WHERE USERNAME = ?";
                        pstmnt = connection.prepareStatement(myDB);
                        pstmnt.setBoolean(1, false);
                        pstmnt.setString(2, parseUsers);
                        boolean execute = pstmnt.execute();   
                    }
                }
                //commit changes to JDBC
                connection.commit();
                connection.setAutoCommit(true);
            } catch(SQLException | ClassNotFoundException ex){
                Logger.getLogger(AdminUserRoles.class.getName()).log(Level.SEVERE, null, ex);           
            } finally{
                if (resultSet != null){
                    try{
                        resultSet.close();
                    } catch (SQLException ex){
                        Logger.getLogger(AdminUserRoles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (statement != null){
                    try{
                        statement.close();
                    } catch (SQLException ex){
                        Logger.getLogger(AdminUserRoles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }	
                if (connection != null){
                    try{
                        connection.close();
                    } catch(SQLException ex){
                        Logger.getLogger(AdminUserRoles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (pstmnt != null){
                    try{
                        pstmnt.close();
                    } catch (SQLException ex){
                        Logger.getLogger(AdminUserRoles.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Won't be used for security reasons
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
     * For security purposes, this method will be invoked to make changes in user's role
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
     * Short servlet description
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes changes to user's role";
    }// </editor-fold>

}
