
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Wallet_Methods extends dbconnect{

    static Scanner sc = new Scanner(System.in);

    // Login Verification Method
    public static void login_verification (String x) {

        // CREATE DB CONNECTION OBJECT
        dbconnect db = new dbconnect();

        Connection conn= null;
        Statement stmt = null;
        
        if(x.equals("1")) {

            System.out.println("Enter Email Address");
            // Declare and Store Email Address Variable
            String Email_Address = sc.nextLine();



            //Connection conn = null;
           // PreparedStatement checkInfo = conn.prepareStatement ("SELECT * FROM EMAIL WHERE EmailAdd ='"+ Email_Address);






        // if email == null then

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
                String Send_Money = "1. Send Money";
                String Request_Funds = "2. Request Money";
                String Wallet_History = "3. Wallet Payment History ";
                String Account_info = "4. Account Information";
                String Exit = "5. Exit";


                System.out.printf(" %15s %15s %15s \n",  Send_Money, Request_Funds, Wallet_History);
                System.out.printf("\n");
                System.out.printf("\t%18s%18s\n", Account_info, Exit);
                // int optionmenu = sc.nextInt();


            }

} else{
        System.out.println(" Invalid Input. Try Again!");
    }

    }

}
