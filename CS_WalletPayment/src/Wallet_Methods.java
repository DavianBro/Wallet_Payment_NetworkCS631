import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WalletInterface extends Wallet_Methods {

    public static void main(String[]args) throws Exception {

            // Declare Time and Date
            LocalDateTime now = LocalDateTime.now();
            // Format Date and Time
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            //Alter the object now to format
            String formatDateTime = now.format(format);
            // Declare Scanner
            Scanner sc = new Scanner(System.in);

            System.out.println(formatDateTime);
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.printf("\n");
            System.out.print("===================== WELCOME TO THE WALLET PAYMENT NETWORK ====================");
            System.out.printf("\n");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.printf("\n");
            System.out.printf("\n");

            System.out.println("    ||====================================================================||");
            System.out.println("    ||(   )                 |   CS631 Deliverable 3  |                (  )||");
            System.out.println("    ||======================| Wallet Payment Network |====================||");
            System.out.println("    ||                             CREATED BY...                          ||");
            System.out.println("    ||                                                                    ||");
            System.out.println("    ||                          Damian Zalewski                           ||");
            System.out.println("    ||                                                                    ||");
            System.out.println("    ||                            Davian Brown                            ||");
            System.out.println("    ||                                                                    ||");
            System.out.println("    ||                             Ahmed Ali                              ||");
            System.out.println("    ||                                                                    ||");
            System.out.println("    ||====================================================================||");
            System.out.println("    ||(   )                 | Wallet Payment Network |               (   )||");
            System.out.println("    ||====================================================================||");


            System.out.println("Enter 1 to Verify That You're Not A Robot");
            String Robot_verify = sc.nextLine();

            if(Robot_verify.equals("1")){

                System.out.println(" Press 1 to Login");
                // User's Response is store in Variable
                String User_Response = sc.nextLine();
                    if(User_Response.equals("1")) {
                        // Test SQL Connection 1st if goof then run the other methods
                        // Method is called from Wallet_Methods

                        login_verification("1");


                    }  else {
                        System.out.println("Invalid Response!");
                        System.exit(0);
                    }
            // Else Statement for the Robot Verification
            }else{

                System.out.println(" Access Denied to Wallet Payment Network. Please Try Again");


            }

}
}
