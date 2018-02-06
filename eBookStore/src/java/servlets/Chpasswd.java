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
public class Chpasswd extends HttpServlet {

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
        //get username from session variable
        String username = request.getSession().getAttribute("actualUser").toString();
        //get passwords from user input form
        String oldPass = request.getParameter("chpasswdpage_oldpass");
        String newPass1 = request.getParameter("chpasswdpage_newpass1");
        String newPass2 = request.getParameter("chpasswdpage_newpass2");
        //set connection parameters to DB
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement pstmnt = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/chpasswd.jsp");
        //try to create a connection to DB and check if user exists
        try{
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement();
            String query = "SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME='"+username+"' AND PASSWORD='"+oldPass+"'";
            resultSet = statement.executeQuery(query);
            Boolean resultSetHasRows = resultSet.next();
            if (!resultSetHasRows) {
                request.setAttribute("errorOldPasswd", "Invalid password!");
                dispatcher.forward(request, response);
            } else if (resultSetHasRows && !newPass1.equals(newPass2)){
                request.setAttribute("errorNewPasswd", "No match!");
                dispatcher.forward(request, response);
            } else if (resultSetHasRows && newPass1.equals(newPass2) && newPass1.equals("")){
                request.setAttribute("errorNewPasswd", "No entry!");
                dispatcher.forward(request, response);   
            } else if (resultSetHasRows && newPass1.equals(newPass2)){
                query = "UPDATE USERS SET PASSWORD=? WHERE USERNAME=?";
                pstmnt = connection.prepareStatement(query);
                pstmnt.setString(1, newPass1);
                pstmnt.setString(2, username);
                pstmnt.execute();
                request.setAttribute("passwdChange", true);
                response.setHeader("Refresh", "2;URL=./main.jsp");
                dispatcher.forward(request, response);
            }
        } catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(Chpasswd.class.getName()).log(Level.SEVERE, null, ex);           
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(Chpasswd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(Chpasswd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(Chpasswd.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pstmnt != null){
                try{
                    pstmnt.close();
                } catch (SQLException ex){
                    Logger.getLogger(Chpasswd.class.getName()).log(Level.SEVERE, null, ex);
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
        request.removeAttribute("errorOldPasswd");
        request.removeAttribute("errorNewPasswd");
        request.removeAttribute("passwdChange");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes password change of user";
    }// </editor-fold>

}