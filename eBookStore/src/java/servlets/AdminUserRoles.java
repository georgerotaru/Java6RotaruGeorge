/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author George
 */
public class AdminUserRoles extends HttpServlet {

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
        //try to create a connection to DB and check if user exists
        if (request.getParameter("adminuserrolepg_update")!=null){
            try{
                Class driverClass = Class.forName(driver);
                connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
                String[] selectedCheckboxes = request.getParameterValues("adminuserrolepg__checkbox");
                Boolean newrole = Boolean.parseBoolean(request.getParameter("adminuserrolepg_role"));
                if (newrole) {
                    connection.setAutoCommit(false);
                    for(String parseUsers : selectedCheckboxes){
                        // realize update of all selected rows
                        String myDB = "UPDATE USERS SET IS_ADMIN = ? WHERE USERNAME = ?";
                        pstmnt = connection.prepareStatement(myDB);
                        pstmnt.setBoolean(1, true);
                        pstmnt.setString(2, parseUsers);
                        boolean execute = pstmnt.execute();
                    }
                } else {
                    connection.setAutoCommit(false);
                    for(String parseUsers : selectedCheckboxes){
                        // realize update of all selected rows
                        String myDB = "UPDATE USERS SET IS_ADMIN = ? WHERE USERNAME = ?";
                        pstmnt = connection.prepareStatement(myDB);
                        pstmnt.setBoolean(1, false);
                        pstmnt.setString(2, parseUsers);
                        boolean execute = pstmnt.execute();   
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                /*statement = connection.createStatement();
                String query = "SELECT IS_ADMIN FROM USERS WHERE USERNAME='"+request.getParameter("actualUser")+"'";
                resultSet = statement.executeQuery(query);
                request.getSession().setAttribute("isAdmin", resultSet.getBoolean("IS_ADMIN"));*/
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
