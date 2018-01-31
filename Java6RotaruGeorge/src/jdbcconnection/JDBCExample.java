/*
 * a-sti.ro
 */
package jdbcconnection;

import java.sql.*;
/**
 *
 * @author gheorgheaurelpacurar
 */
public class JDBCExample {
    public static void main (String[] args)
    {
        String user = "ebook";
        String password = "ebook";
        String url = "jdbc:derby://localhost:1527/EBOOKSTORE;create=true";
        //String driver = "org.apache.derby.jdbc.ClientDataSource40";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try
        {
            Class driverClass = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT ISBN, TITLE, DESCRIPTION FROM EBOOK.EBOOKS");
            boolean resultSetHasRows = resultSet.next(); 
            if (resultSetHasRows)
            {
                String currentID = "";
                String currentName = "";
                String currentDescription = "";
                System.out.println("ISBN                NAME");
                System.out.println("=================   =======================");
                while(resultSet.next()){
                    currentID = resultSet.getString(1);
                    currentName = resultSet.getString(2); 
                    currentDescription = resultSet.getString(3);
                    System.out.println(currentID +"   "+currentName);
                    System.out.println(currentDescription);
                }
            }
            else
            {
                System.out.println("No rows found in ResultSet");
            }
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            if (resultSet != null)
            {
                try
                {
                    resultSet.close();
                }
                catch (Exception ex){System.out.println(ex);}
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception ex){System.out.println(ex);}
            }	
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception ex){System.out.println(ex);}
            }
        }	
    }
}
