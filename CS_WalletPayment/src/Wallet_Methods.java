
import java.util.*;
public class Wallet_Methods {

    static Scanner sc = new Scanner(System.in);

    public static void login_verification (String x) {

    if(x.equals("1")) {
    System.out.println("Enter Email Address");
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
                //System.out.printf
                String Withdraw = "1. Withdraw";
                String Deposit = "2. Deposit";
                String TransferFunds = "3.Transfer Funds";
                String CheckBalance = "4.Check Balance";
                String Exit = "5. Exit";

                Scanner reader = new Scanner(System.in);
                System.out.printf("%15s %15s %20s\n", Withdraw, Deposit, TransferFunds );
                System.out.printf("\n");
                System.out.printf("\t%18s%18s\n", CheckBalance, Exit);
                int optionmenu = reader.nextInt();


            }





}
    }



}
