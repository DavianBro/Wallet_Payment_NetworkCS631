
import java.util.*;
import java.sql.*;
public class Wallet_Methods {

    static Scanner sc = new Scanner(System.in);

    // Method to Connect to SQL Database
    public static void sql_connection() throws ClassNotFoundException, SQLException {
        // to be customized according to your own devices
        String url = "jdbc:mysql://localhost:3306/WalletNetwork";
        String uname = "root"; //username I have set in my device, change to whatever you have set in your device
        String password = "Wallet_network631";

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Establish connection to MySQL
            conn = DriverManager.getConnection(url, uname, password);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        Statement stmt = conn.createStatement();
        stmt.execute("SELECT * FROM `Bank_Account`");
        stmt.close();
        conn.close();

        //  try {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        // Connection con = DriverManager.getConnection(url, uname, password);

        //  Statement st = con.createStatement();
        //  ResultSet result = st.executeQuery("select EmailAdd from EMAIL;");

        //  while (result.next()) {
        //     String email_verify = result.getString(1);
        //    if (login_verify.equals(email_verify)) {
        //   System.out.println("Thanks for logging in, welcome back");
        //   }

        //   }


        //  con.close();
        //   } catch (SQLException e) {
        //      e.printStackTrace();
    }

    // Login Verification Method
    public static void login_verification (String x) {

    if(x.equals("1")) {

    System.out.println("Enter Email Address");

    // Declare and Store Email Address Variable
    String Email_Address = sc.nextLine();

    // If Login Equals Email in db then prompt user for password
    // Initialize sql to Email Address and check if its in the data base
        System.out.println("Enter Password");
        String Login_Password = sc.nextLine();
        // Login Password must equal 0631
            if (Login_Password.equals("0631")){ // and equals an email in the database
                System.out.println();
                System.out.println();
                System.out.println("Welcome Back " + " WALLER USER INSERT VARIABLE HERE" + " Here Are Your Options: "); // Change User to name in Databse
                System.out.println(" --------------------------------------------");

                System.out.println();
                //System.out.print
                String Deposit = "1. Deposit";
                String Send_Money = "2. Send Money";
                String Receive_Funds = "3. Receive";
                String Wallet_History = "4. Wallet Payment History ";
                String CheckBalance = "5.Check Balance";
                String Exit = "6. Exit";


                System.out.printf("%15s %15s %15s %15s \n",  Deposit, Send_Money, Receive_Funds, Wallet_History);
                System.out.printf("\n");
                System.out.printf("\t%18s%18s\n", CheckBalance, Exit);
                // int optionmenu = sc.nextInt();


            }





} else{
        System.out.println(" Invalid Input. Try Again!");
    }

    }



}
