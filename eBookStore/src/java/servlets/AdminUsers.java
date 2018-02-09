/*
 * Document : AdminUsers.java
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
 * This servlet class implements changes made to user details in eBookStore java web
 * application.
 * 
 * @author George
 */
public class AdminUsers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Connects to JDBC and make different changes to user information
     * accordingly to user options in web page form
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
        ResultSet resultSetCnp = null;
        PreparedStatement pstmnt = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/adminUsers.jsp");
        try{
            //connect to DB and check if user exists
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
            //to do if Submit button pushed
            if (request.getParameter("adminuserpg_submit")!=null){
                //this will finally insert a new user
                if (!resultSetHasRows && !pgUsername.equals("") && !pgPassword.equals("") && !pgCnp.equals("")){
                    //test if CNP value has 13 characters
                    if (pgCnp.length() == 13) {
                        String query = "SELECT * FROM USERS WHERE CNP='"+pgCnp+"'";
                        resultSetCnp = statement.executeQuery(query);
                        Boolean resultSetCnpHasRows = resultSetCnp.next();
                        //insert a new user if CNP not in DB
                        if (!resultSetCnpHasRows) {
                            query = "INSERT INTO USERS VALUES ('"+pgCnp+"', '"+pgUsername.toLowerCase()+"', '"+pgPassword+"', "+pgRole+")";
                            statement.execute(query);
                            request.setAttribute("adminuserpg_message", "User successfuly added to list!");
                        //send message if CNP already in DB
                        } else {
                            request.setAttribute("adminuserpg_message", "CNP already assigned to username "+resultSet.getString(2));
                        }
                    //send message if CNP does not contain 13 characters
                    } else {
                        request.setAttribute("adminuserpg_message", "Wrong CNP");
                    } 
                //send message if user tries to change "admin" user information
                } else if (resultSetHasRows && pgUsername.equals("admin")) {
                    request.setAttribute("adminuserpg_message", "Cannot make changes on username admin.");
                //send message if user tries to insert a new user that already exists in DB
                } else if (resultSetHasRows) {
                    request.setAttribute("adminuserpg_message", "User "+pgUsername+" already in database.");
                //test if user in DB and different from "admin"
                } else if (resultSetHasRows && !pgUsername.equals("admin")) {
                    //update user password
                    if (!pgPassword.equals("")) {
                        String query = "UPDATE USERS SET PASSWORD = '"+pgPassword+"' WHERE USERNAME = '"+pgUsername+"'";
                        statement.execute(query);
                        request.setAttribute("adminuserpg_message", "Password for user "+pgUsername+" updated!");
                    //update user CNP if there were 13 characters inputed
                    } else if (!pgCnp.equals("")) {
                        if (pgCnp.length() == 13) {
                            String query = "UPDATE USERS SET CNP = '"+pgCnp+"' WHERE USERNAME = '"+pgUsername+"'";
                            statement.execute(query);
                            request.setAttribute("adminuserpg_message", "CNP for user "+pgUsername+" updated!");
                        } else {
                            request.setAttribute("adminuserpg_message", "Wrong CNP");
                        }
                    }
                //send message if invalid data was entered
                } else {
                    request.setAttribute("adminuserpg_message", "Invalid input.");
                }
            //to do if Delete button pushed
            } else if (request.getParameter("adminuserpg_delete")!=null) {
                //to do if username is not in DB
                if (!resultSetHasRows) request.setAttribute("adminuserpg_message", "No such username");
                //to do if username is in DB
                else {
                    //send message if trying to delete "admin" user
                    if (pgUsername.equals("admin")) request.setAttribute("adminuserpg_message", "Cannot delete user admin!");
                    //delete user from userlist
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
     * For security purposes, this method will be invoked to make changes in user information
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
     * Short servlet description
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes changes in user list details";
    }// </editor-fold>

}
