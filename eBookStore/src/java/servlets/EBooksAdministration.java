/*
 * Document : EBooksAdministration.java
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
 * This servlet class implements the use of ordering, inserting, modifying and updating
 * eBooks from eBooksStore java web application.
 * @author George
 */
public class EBooksAdministration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Connects to JDBC and performs CRUD operations.
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
        PreparedStatement psebooks = null;
        PreparedStatement psauthors = null;
        PreparedStatement pseratings = null;
        String sqlUser = "ebook";
        String sqlPasswd = "ebook";
        String sqlUrl = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        //get values from session variables
        String thisUser = request.getSession().getAttribute("actualUser").toString();
        String thisCnp = request.getSession().getAttribute("actualCnp").toString();
        //get values from selected checkboxes or pushed details button in web page form
        String[] selectedCheckboxes = request.getParameterValues("ebookspg__checkbox");
        String[] eBookDetails = request.getParameterValues("ebookspg_details");
        
        try{
            //connect to DB
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(sqlUrl, sqlUser, sqlPasswd);
            statement = connection.createStatement(); 
            
            //to do if Order button pushed
            if (request.getParameter("ebookspg_order")!=null && selectedCheckboxes.length > 0){
                String myDB = "INSERT INTO ORDERS(TITLE, CNP, PRICE, STATUS, ISBN, TYPE, GENRE) VALUES (?, ?, ?, ?, ?, ?, ?)";
                pstmnt = connection.prepareStatement(myDB);
                connection.setAutoCommit(false);
                for (String parseISBN : selectedCheckboxes){
                    //query DB for every checkbox checked
                    String query = "SELECT TITLE, PRICE, TYPE, GENRE FROM EBOOKS WHERE ISBN='"+parseISBN+"'";
                    resultSet = statement.executeQuery(query);
                    while (resultSet.next()){
                        String setTitle = resultSet.getString(1);
                        Double orderPrice = resultSet.getDouble(2);
                        String setType = resultSet.getString(3);
                        String setGenre = resultSet.getString(4);
                        pstmnt.setString(1, setTitle);
                        pstmnt.setString(2, thisCnp);
                        pstmnt.setDouble(3, orderPrice);
                        pstmnt.setString(4, "SOLD");
                        pstmnt.setString(5, parseISBN);
                        pstmnt.setString(6, setType);
                        pstmnt.setString(7, setGenre);
                        boolean execute = pstmnt.execute();
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                //send message to web page
                request.setAttribute("orderCompleted", "ORDER COMPLETED. THANK YOU!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/orderHistory.jsp");
                dispatcher.forward(request, response);
                
            //to do if Insert button pushed
            } else if(request.getParameter("insertebookpg_insert") != null){
                //verify if ISBN inputed in DB
                String pgIsbn = request.getParameter("insertebookpg_isbn");
                String query = "SELECT ISBN FROM EBOOKS WHERE ISBN='"+pgIsbn+"'";
                resultSet = statement.executeQuery(query);
                boolean resultSetHasRows = resultSet.next();
                //to do if ISBN in DB
                if (resultSetHasRows){
                    request.setAttribute("ebookadded", "ISBN already in database!");
                //to do if ISBN not in DB
                } else {
                    String pgTitle = request.getParameter("insertebookpg_title");
                    String pgAuthorFName = request.getParameter("insertebookpg_authorfname");
                    String pgAuthorLName = request.getParameter("insertebookpg_authorlname");
                    String pgAuthorCnp = request.getParameter("insertebookpg_authorcnp");
                    //to do if CNP is not 13 characters long
                    if (pgAuthorCnp.length()!=13){
                        request.setAttribute("pgmsg", "Incorrect CNP entered!");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/insertEBook.jsp");
                        dispatcher.forward(request, response);
                    //to do if CNP correct
                    } else {
                        String pgDescription = request.getParameter("insertebookpg_description");
                        String pgType = request.getParameter("insertebookpg_type");
                        String pgGenre = request.getParameter("insertebookpg_genre");
                        Double pgPrice = Double.parseDouble(request.getParameter("insertebookpg_price"));
                        String pgPageNo = request.getParameter("insertebookpg_pageno");
                        connection.setAutoCommit(false);
                        String queryEbooks = "INSERT INTO EBOOKS VALUES ('"+pgIsbn+"','"+pgTitle+"','"+pgDescription+"','"+
                                pgType+"','"+pgGenre+"',"+pgPrice+",'"+pgPageNo+"')";
                        statement.execute(queryEbooks);
                        //query DB if CNP in DB
                        query = "SELECT * FROM AUTHORS WHERE CNP='"+pgAuthorCnp+"'";
                        resultSet = statement.executeQuery(query);
                        resultSetHasRows = resultSet.next();
                        //to do if CNP not in DB
                        if (!resultSetHasRows) {
                            String queryAuthors = "INSERT INTO AUTHORS VALUES('"+pgAuthorCnp+"','"+pgAuthorFName+"','"+pgAuthorLName+"')";
                            statement.execute(queryAuthors);
                        }
                        String queryEBookAuthors = "INSERT INTO EBOOK_AUTHORS VALUES('"+pgIsbn+"','"+pgAuthorCnp+"')";
                        statement.execute(queryEBookAuthors);
                        connection.commit();
                        connection.setAutoCommit(true);
                        //send message to web page
                        String sendMsg = "ISBN "+pgIsbn+" added to list!";
                        request.setAttribute("ebookadded", sendMsg);
                    }
                }
                
            //to do if Delete button pushed and checkboxes checked
            } else if (request.getParameter("ebookspg_delete") != null && selectedCheckboxes.length > 0){
                String deleteAuthors = "DELETE FROM EBOOK_AUTHORS WHERE ISBN=?";
                String deleteRatings = "DELETE FROM EBOOK_RATINGS WHERE ISBN=?";
                String deleteEBook = "DELETE FROM EBOOKS WHERE ISBN=?";                
                psauthors = connection.prepareStatement(deleteAuthors);
                pseratings = connection.prepareStatement(deleteRatings);
                psebooks = connection.prepareStatement(deleteEBook);
                //get values from selected checkboxes in web page form
                connection.setAutoCommit(false);
                for (String parseISBN : selectedCheckboxes){
                    psauthors.setString(1, parseISBN);
                    boolean execute1 = psauthors.execute();
                    pseratings.setString(1, parseISBN);
                    boolean execute2 = pseratings.execute();
                    psebooks.setString(1, parseISBN);
                    boolean execute3 = psebooks.execute();
                }
                connection.commit();
                connection.setAutoCommit(true);
                //send message to web page
                request.setAttribute("ebookadded", "EBOOKS DELETED");
                
            //to do if Modify button pushed and one checkbox checked
            } else if (request.getParameter("ebookspg_modify") != null && selectedCheckboxes.length == 1){
                //query JDBC for joined tables and get values
                String ebookIsbn = request.getParameter("ebookspg__checkbox");
                String query = "SELECT EBOOKS.*, AUTHORS.* FROM EBOOKS JOIN (AUTHORS CROSS JOIN EBOOK_AUTHORS)"
                    + " ON (EBOOK_AUTHORS.CNP = AUTHORS.CNP AND EBOOK_AUTHORS.ISBN=EBOOKS.ISBN)"
                    + " WHERE EBOOKS.ISBN='"+ebookIsbn+"'";
                resultSet = statement.executeQuery(query);
                resultSet.next();
                String ebookTitle = resultSet.getString(2);
                String ebookDescription = resultSet.getString(3);
                String ebookType = resultSet.getString(4);
                String ebookGenre = resultSet.getString(5);
                Double ebookPrice = resultSet.getDouble(6);
                String ebookPages = resultSet.getString(7);
                String authorCnp = resultSet.getString(8);
                String authorFName = resultSet.getString(9);
                String authorLName = resultSet.getString(10);
                //send values to web page variables
                request.setAttribute("modifIsbn", ebookIsbn);
                request.setAttribute("modifTitle", ebookTitle);
                request.setAttribute("modifDescription", ebookDescription);
                request.setAttribute("modifType", ebookType);
                request.setAttribute("modifGenre", ebookGenre);
                request.setAttribute("modifPrice", ebookPrice);
                request.setAttribute("modifPages", ebookPages);
                request.setAttribute("modifCnp", authorCnp);
                request.setAttribute("modifFName", authorFName);
                request.setAttribute("modifLName", authorLName);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/modifyEBook.jsp");
                dispatcher.forward(request, response);
                
            //to do if Modify button pushed and none or more checkboxes checked
            } else if (request.getParameter("ebookspg_modify") != null && selectedCheckboxes.length != 1) {
                request.setAttribute("ebookadded", "YOU CAN EDIT ONLY ONE EBOOK AT A TIME!");
                
            //to do if Details button pushed
            } else if (request.getParameter("ebookspg_details") != null) {
                //get value of ISBN and test if user has rated this ebook
                for (String ebookIsbn : eBookDetails){
                    String query = "SELECT CNP, RATING FROM EBOOK_RATINGS WHERE CNP='"+request.getSession().getAttribute("actualCnp")+
                            "' AND ISBN='"+ebookIsbn+"'";
                    resultSet = statement.executeQuery(query);
                    boolean hasRows = resultSet.next();
                    if (hasRows) request.setAttribute("rated", true);
                    else request.setAttribute("rated", false);
                    request.setAttribute("ebookIsbn", ebookIsbn);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/aboutebooks.jsp");
                dispatcher.forward(request, response); 
                
            //to do if Update button pushed
            } else if (request.getParameter("modifebookpg_update") != null){
                //get values from web page parameters
                String ebookIsbn = request.getParameter("ebookspg__checkbox");
                String ebookTitle = request.getParameter("modifebookpg_title");
                String ebookDescription = request.getParameter("modifebookpg_description");
                String ebookType = request.getParameter("modifebookpg_type");
                String ebookGenre = request.getParameter("modifebookpg_genre");
                Double ebookPrice = Double.parseDouble(request.getParameter("modifebookpg_price"));
                String ebookPages = request.getParameter("modifebookpg_pageno");
                String authorCnp = request.getParameter("modifebookpg_authorcnp");
                String authorFName = request.getParameter("modifebookpg_authorfname");
                String authorLName = request.getParameter("modifebookpg_authorlname");
                //to do if CNP is not 13 characters long
                if (authorCnp.length()!=13){
                        request.setAttribute("pgmsg", "Incorrect CNP entered!");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("./manage/modifyEBook.jsp");
                        dispatcher.forward(request, response);
                //to do if CNP correct
                } else {
                    connection.setAutoCommit(false);
                    //query JDBC if combination CNP and ISBN is a match
                    String query = "SELECT * FROM EBOOK_AUTHORS WHERE CNP='"+authorCnp+"' AND ISBN='"+ebookIsbn+"'";
                    resultSet = statement.executeQuery(query);
                    //to do if match true
                    if (resultSet.next()){
                        //update author name
                        String queryAuthors = "UPDATE AUTHORS SET FIRST_NAME='"+authorFName+"', LAST_NAME='"+authorLName+"' WHERE CNP='"+authorCnp+"'";
                        statement.execute(queryAuthors);
                        //update ebook details
                        String queryEbooks = "UPDATE EBOOKS SET TITLE='"+ebookTitle+"', DESCRIPTION='"+ebookDescription+"', TYPE='"+ebookType+
                                "', GENRE='"+ebookGenre+"', PRICE="+ebookPrice+", PAGES='"+ebookPages+"' WHERE ISBN='"+ebookIsbn+"'";
                        statement.execute(queryEbooks);
                    //to do if no match
                    } else {
                        //delete current match
                        String deleteEBookAuthor = "DELETE FROM EBOOK_AUTHORS WHERE ISBN='"+ebookIsbn+"'";
                        statement.execute(deleteEBookAuthor);
                        //query JDBC for CNP match
                        query = "SELECT * FROM AUTHORS WHERE CNP='"+authorCnp+"'";
                        resultSet = statement.executeQuery(query);
                        //insert author details if no match
                        if(!resultSet.next()){
                            String queryAuthors = "INSERT INTO AUTHORS VALUES ('"+authorCnp+"','"+authorFName+"','"+authorLName+"')";
                            statement.execute(queryAuthors);
                        //update author details if match
                        } else {
                            String queryAuthors = "UPDATE AUTHORS SET FIRST_NAME='"+authorFName+"', LAST_NAME='"+authorLName+"' WHERE CNP='"+authorCnp+"'";
                            statement.execute(queryAuthors);
                        }
                        //insert ISBN and CNP combination
                        String queryEbAuth = "INSERT INTO EBOOK_AUTHORS VALUES ('"+ebookIsbn+"','"+authorCnp+"')";
                        statement.execute(queryEbAuth);
                        //update ebook details
                        String queryEbooks = "UPDATE EBOOKS SET TITLE='"+ebookTitle+"', DESCRIPTION='"+ebookDescription+"', TYPE='"+ebookType+
                                "', GENRE='"+ebookGenre+"', PRICE="+ebookPrice+", PAGES='"+ebookPages+"' WHERE ISBN='"+ebookIsbn+"'";
                        statement.execute(queryEbooks);
                    }
                    connection.commit();
                    connection.setAutoCommit(true);
                    //send message to web page
                    String sendMsg = "ISBN "+ebookIsbn+" updated!";
                    request.setAttribute("ebookadded", sendMsg);
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/eBooks.jsp");
            dispatcher.forward(request, response);
        } catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(EBooksAdministration.class.getName()).log(Level.SEVERE, null, ex); 
        //catch exception if no checkbox checked
        } catch (NullPointerException ex) {
            request.setAttribute("ebookadded", "INVALID OPTION!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./orders/eBooks.jsp");
            dispatcher.forward(request, response);
        } finally{
            if (resultSet != null){
                try{
                    resultSet.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBooksAdministration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBooksAdministration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }	
            if (connection != null){
                try{
                    connection.close();
                } catch(SQLException ex){
                    Logger.getLogger(EBooksAdministration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (pstmnt != null){
                try{
                    pstmnt.close();
                } catch (SQLException ex){
                    Logger.getLogger(EBooksAdministration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
     * For security purposes, this method will be invoked to modify eBook and author details
     * and to order eBoooks
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
        return "With the use of this servlet an user or an administrator can place an order "
                + "and an administrator can insert, modify and update eBook details.";
    }// </editor-fold>

}
