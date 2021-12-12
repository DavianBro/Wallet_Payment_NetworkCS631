import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbconnect {

    // Initialize DB Variables
    static String url = "jdbc:mysql://localhost:3306/WalletNetwork";
    static  String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String uname = "root"; //username I have set in my device, change to whatever you have set in your device
   static  String password = "Wallet_network631";

    public static Connection connect () throws ClassNotFoundException, SQLException {

        try (Connection conn = DriverManager.getConnection(url, uname, password)) {

            if (conn != null) {
                System.out.println("Connected to the database!");
                return conn;
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }



}
