/*
 * DBConnect class connects to a local database and inserts data to predefined tables
 */
package database.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author george
 */
public class DBConnect {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // login credentials for FIRSTDB
        String host1 = "jdbc:derby://localhost:1527/FIRSTDB";
        String username1 = "firstdb";
        String passwd1 = "firstdb";
        
        // login credentials for SECONDDB
        String host2 = "jdbc:derby://localhost:1527/SECONDDB";
        String username2 = "seconddb";
        String passwd2 = "seconddb";
        
        Connection con1 = DriverManager.getConnection( host1, username1, passwd1);
        Connection con2 = DriverManager.getConnection( host2, username2, passwd2);
        
        // create Statement from the connections
        Statement st1 = con1.createStatement();
        Statement st2 = con2.createStatement();
        
        // insert data into FIRSTTABLE
        st1.executeUpdate("INSERT INTO FIRSTTABLE " + "VALUES (10, 'TEN')");
        st1.executeUpdate("INSERT INTO FIRSTTABLE " + "VALUES (20, 'TWENTY')");
        st1.executeUpdate("INSERT INTO FIRSTTABLE " + "VALUES (30, 'THIRTY')");
        
        // insert data into SECONDTABLE
        st2.executeUpdate("INSERT INTO SECONDTABLE " + "VALUES (100, 'ONE HUNDRED')");
        st2.executeUpdate("INSERT INTO SECONDTABLE " + "VALUES (200, 'TWO HUNDRED')");
        st2.executeUpdate("INSERT INTO SECONDTABLE " + "VALUES (300, 'THREE HUNDRED')");
    }
    
}
