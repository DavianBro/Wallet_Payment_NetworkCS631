

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;

public class  WalletInterface extends Wallet_Methods {

    public static void main(String[]args) throws Exception {

       // if  sql_connection();



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
            System.out.print("============= WELCOME TO THE WALLET PAYMENT NETWORK =============");
            System.out.printf("\n");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
            System.out.printf("\n");
            System.out.printf("\n");


            System.out.println("Enter 1 to Verify That You're Not A Robot");
            String Robot_verify = sc.nextLine();

            if(Robot_verify.equals("1")){

                System.out.println(" Press 1 to Login");
                // User's Response is store in Variable
                String User_Response = sc.nextLine();
                    if(User_Response.equals("1")){

                        // Method is called from Wallet_Methods
                        login_verification("1");

                    } else if (User_Response.equals("2")){

                    } else {

                    }

                // Call methods
            // Else Statement for the Robot Verification
            }else{

                System.out.println(" Access Denied to Wallet Payment Network. Please Try Again");


            }






        /*
      * Once Logged in
      * Account info
      * Send money
      * Search Transactions
      * Request Money
      * Search Statements
      * Signout
      * Add or remove email, bank account, phone number, modify details

       */




}
}
