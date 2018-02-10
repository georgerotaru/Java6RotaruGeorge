/*
 * Document : AdminUsers.java
 * Author : George
 * Copyright : George
 */
package servlets;

import getandset.Summary;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet class implements an inventory upon all transactions and 
 * collections the user has in the eBookStore java web application.
 * 
 * @author George
 */
public class EBookInventory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Connects to JDBC and retrieves data for statistical purposes
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
        PreparedStatement pstmnt = null;
        //config JDBC connection
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/adminEBooksInventory.jsp");
        try{
            //connect to JDBC
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement();
            //prepare a list with Summary objects
            List<Summary> ebooks = new LinkedList<>();
            //prepare different queries for the DB
            String query = "SELECT ISBN, TITLE FROM EBOOKS";
            String query1 = "SELECT AS COUNTISBN FROM EBOOKS";
            String query2 = "SELECT COUNT(CNP) FROM USERS";
            String query3 = "SELECT SUM(PRICE) FROM USERS";
            String query4 = "SELECT EBOOK_RATINGS.ISBN FROM RATINGS JOIN EBOOK_RATINGS ON EBOOK_RATINGS.RATING=RATINGS.RATING GROUP BY ISBN ORDER BY SUM(RATINGS.VALUE) DESC";
            String query5 = "SELECT TITLE, SUM(PRICE) AS TOTAL FROM ORDERS GROUP BY TITLE ORDER BY SUM(PRICE) DESC";
            //retrieve and send to web page the 3 most bought eBooks
            resultSet = statement.executeQuery(query5);
            resultSet.next();
            int counter = 0;
                do {
                    Summary ebook5 = new Summary();
                    ebook5.setEbookTitle(resultSet.getString("TITLE"));
                    ebook5.setEbookSum(resultSet.getDouble("TOTAL"));
                    ebooks.add(ebook5);
                    resultSet.next();
                    counter++;
                } while (counter<3);
            request.setAttribute("ebooks", ebooks);
            dispatcher.forward(request, response);
        } catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(EBookInventory.class.getName()).log(Level.SEVERE, null, ex);           
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBookInventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBookInventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(EBookInventory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pstmnt != null){
                try{
                    pstmnt.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBookInventory.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * Will not be used
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
        return "Connects to JDBC and retrieves data for statistical purposes";
    }// </editor-fold>

}
