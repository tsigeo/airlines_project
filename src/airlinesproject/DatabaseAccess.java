package airlinesproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccess {

    public static ResultSet DataBaser(String query) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        Statement stmt = (Statement) con.createStatement();
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        return rs;
    }
    
    
    public static int GetMaxId(String column) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String QUERY = "SELECT MAX(reservation_id) FROM `" + column+"`;";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        Statement stmt = (Statement) con.createStatement();
        stmt.executeQuery(QUERY);
        ResultSet rs = stmt.getResultSet();
        
        int id=-1;
        
        while (rs.next()) {
            id = rs.getInt(1);
            System.out.println(id);
//            Username = rs.getString("id");
        }
        con.close();
        return id;

    }
    
    
    public static int GetMaxIdFlight(String column) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String QUERY = "SELECT MAX(flight_id) FROM `" + column+"`;";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        Statement stmt = (Statement) con.createStatement();
        stmt.executeQuery(QUERY);
        ResultSet rs = stmt.getResultSet();
        
        int id=-1;
        
        while (rs.next()) {
            id = rs.getInt(1);
            System.out.println(id);
//            Username = rs.getString("id");
        }
        con.close();
        return id;

    }
    
    
    public static int GetMaxIdCustomer(String column) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String QUERY = "SELECT MAX(customer_id) FROM `" + column+"`;";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        Statement stmt = (Statement) con.createStatement();
        stmt.executeQuery(QUERY);
        ResultSet rs = stmt.getResultSet();
        
        int id=-1;
        
        while (rs.next()) {
            id = rs.getInt(1);
            System.out.println(id);
//            Username = rs.getString("id");
        }
        con.close();
        return id;

    }

    public static void DataBaserInsert(String query) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
        Statement stmt = (Statement) con.createStatement();
        stmt.executeUpdate(query);
    }



}
