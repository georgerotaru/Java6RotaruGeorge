/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class AdminUsers extends HttpServlet {

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
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSetCnp = null;
        PreparedStatement pstmnt = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/adminUsers.jsp");
        //try to create a connection to DB and check if user exists
        try{
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement();
            String pgUsername = request.getParameter("adminuserspg_username");
            String pgCnp = request.getParameter("adminuserspg_cnp");
            String pgPassword = request.getParameter("adminuserspg_pass");
            Boolean pgRole = Boolean.parseBoolean(request.getParameter("adminuserspg_role"));
            String queryUsername = "SELECT * FROM USERS WHERE USERNAME='"+pgUsername+"'";
            resultSet = statement.executeQuery(queryUsername);
            Boolean resultSetHasRows = resultSet.next();
            if (request.getParameter("adminuserpg_submit")!=null){                
                if (!resultSetHasRows && !pgUsername.equals("") && !pgPassword.equals("") && !pgCnp.equals("")){
                    if (pgCnp.length() == 13) {
                        String query = "SELECT * FROM USERS WHERE CNP='"+pgCnp+"'";
                        resultSetCnp = statement.executeQuery(query);
                        Boolean resultSetCnpHasRows = resultSetCnp.next();
                        if (!resultSetCnpHasRows) {
                            query = "INSERT INTO USERS VALUES ('"+pgCnp+"', '"+pgUsername.toLowerCase()+"', '"+pgPassword+"', "+pgRole+")";
                            statement.execute(query);
                            request.setAttribute("adminuserpg_message", "User successfuly added to list!");
                        } else {
                            request.setAttribute("adminuserpg_message", "CNP already assigned to a username "+resultSet.getString(2));
                        }
                    } else {
                        request.setAttribute("adminuserpg_message", "Wrong CNP");
                    } 
                } else if (resultSetHasRows) {
                    request.setAttribute("adminuserpg_message", "User "+pgUsername+" already in database!");
                } else if (resultSetHasRows && !pgUsername.equals("admin")) {
                    if (!pgPassword.equals("")) {
                        String query = "UPDATE USERS SET PASSWORD = '"+pgPassword+"' WHERE USERNAME = '"+pgUsername+"'";
                        statement.execute(query);
                        request.setAttribute("adminuserpg_message", "Password for user "+pgUsername+" updated!");
                    } else if (!pgCnp.equals("")) {
                        if (pgCnp.length() == 13) {
                            String query = "UPDATE USERS SET CNP = '"+pgCnp+"' WHERE USERNAME = '"+pgUsername+"'";
                            statement.execute(query);
                            request.setAttribute("adminuserpg_message", "CNP for user "+pgUsername+" updated!");
                        } else {
                            request.setAttribute("adminuserpg_message", "Wrong CNP");
                        }
                    }
                } else {
                    request.setAttribute("adminuserpg_message", "Invalid input");
                }
            } else if (request.getParameter("adminuserpg_delete")!=null) {
                if (!resultSetHasRows) request.setAttribute("adminuserpg_message", "No such username");
                else {
                    if (pgUsername.equals("admin")) request.setAttribute("adminuserpg_message", "Cannot delete user admin !");
                    else {
                        String query = "DELETE FROM USERS WHERE USERNAME = '"+pgUsername+"'";
                        statement.execute(query);
                        request.setAttribute("adminuserpg_message", "User "+pgUsername+" deleted.");
                    }
                }
            }
        } catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);           
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pstmnt != null){
                try{
                    pstmnt.close();
                } catch (SQLException ex){
                    Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
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
        request.removeAttribute("adminuserpg_message");
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
