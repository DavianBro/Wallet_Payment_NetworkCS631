
import java.util.*;
public class Wallet_Methods {

    static Scanner sc = new Scanner(System.in);

    public static void login_verification (String x) {

    if(x.equals("1")) {
    System.out.println("Enter Email Address");
    String Email_Address = sc.nextLine();
    // Initialize sql to Email Address and check if its in the data base
        System.out.println("Enter Password");
        String Login_Password = sc.nextLine();
        // Login Password must equal 0631
            if (Login_Password.equals("0631")){ // and equals an email in the database
                System.out.println();
                System.out.println();
                System.out.println("Welcome Back " + " WALLER USER INSERT VARIABLE HERE" + " Here Are Your Options: "); // Change User to name in Databse
                System.out.println(" --------------------------------------------");




            }





}
    }



}
