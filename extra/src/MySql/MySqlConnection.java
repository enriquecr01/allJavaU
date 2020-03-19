package MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    //mysql parameters
    private static final String SERVER = "localhost";
    private static final String DATABASE = "extra7mos2018";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    //get connection
    public static Connection getConnection() {
        //connection
        Connection connection = null;
        try {
            // connection string
            String connectionString = "jdbc:mysql://" + SERVER + "/" + DATABASE + "?user=" + USER;
            // password
            if (PASSWORD != "") connectionString += "&password=" + PASSWORD;
            // MySql Java Driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // connection
            connection = DriverManager.getConnection(connectionString);
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Class Not Found Exception : " + ex.getMessage());
        }
        catch(InstantiationException ex) {
            System.out.println("Instantiation Exception : " + ex.getMessage());
        }
        catch(IllegalAccessException ex) {
            System.out.println("Illegal Access Exception : " + ex.getMessage());
        }
        catch(SQLException ex) {
            System.out.println("General SQL Exception : " + ex.getMessage());
        }
        catch(Exception ex) {
            System.out.println("General Exception : " + ex.getMessage());
        }
        finally {
            return connection; //return connection
        }
    }

}
