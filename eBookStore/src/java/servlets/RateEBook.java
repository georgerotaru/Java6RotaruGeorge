/*
 * Document : AdminUsers.java
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class implements user eBook rating for user logged in eBookStore
 * java web application.
 * 
 * @author George
 */
public class RateEBook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Connects to JDBC and updates current user rating
     * for the eBook he is currently viewing
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get values from web page
        String useIsbn = request.getParameter("useIsbn");
        String rating = request.getParameter("aboutebookspg_rate");
        String userCnp = request.getSession().getAttribute("actualCnp").toString();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        //JDBC credentials
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/aboutebooks.jsp");
        try{
            //create connection to JDBC
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement();
            //insert user rating in DB
            String query = "INSERT INTO EBOOK_RATINGS VALUES ('"+useIsbn+"','"+userCnp+"','"+rating+"')";
            statement.execute(query);
            //send value to web page
            request.setAttribute("ebookIsbn", useIsbn);
            dispatcher.forward(request, response);
        } catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(RateEBook.class.getName()).log(Level.SEVERE, null, ex);           
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(RateEBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(RateEBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(RateEBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * It was used just because all forms in application use POST method.
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
     * No use.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Short servlet description
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This servlet computes eBook rating from currently logged in user";
    }// </editor-fold>

}
