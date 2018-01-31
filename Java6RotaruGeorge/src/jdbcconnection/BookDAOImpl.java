/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author George
 */
public class BookDAOImpl {
    static{
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch(ClassNotFoundException ex){
        }
    }
    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:derby://localhost:1527/EBOOKSTORE", "ebook", "ebook");
    }
    
    private void closeConnection(Connection connection){
        if(connection == null)
            return;
        try{
            connection.close();
        } catch(SQLException ex){
        }
    }
}
