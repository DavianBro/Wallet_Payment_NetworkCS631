

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class  WalletInterface extends Wallet_Methods {

    public static void main(String[]args)   {
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

        // Add and format date
        if(Robot_verify == "1"){
            System.out.println(" 1.) Press 1 to Login");
            System.out.println(" 2.) Press 2 to Create Account");

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
