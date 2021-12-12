
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Wallet_Methods extends dbconnect {

    static Scanner sc = new Scanner(System.in);

    // Login Verification Method
    public static void login_verification (String x) throws Exception {

            try{

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, password);

                if(x.equals("1")) {

                    System.out.println("Enter Email Address");

                    // Declare and Store Email Address Variable
                    String Email_Address = sc.nextLine();

                    Statement st = con.createStatement();
                    ResultSet result = st.executeQuery("select EmailAdd from EMAIL where EmailAdd ='"+ Email_Address + "';");
                    // if email == null then

                    if (result.next()) {
                            // Had to remove while LOOP was giving error
                            String email_verify = result.getString(1);
                            if (Email_Address.equals(email_verify)) {
                                System.out.println("User Email " + Email_Address + " Identified in Database, Please Enter Password");
                                System.out.println();
                                System.out.println("Enter Password");
                                String Login_Password = sc.nextLine();

                                if (Login_Password.equals("0631")) { // and equals an email in the database
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("Welcome Back " + " WALLER USER INSERT VARIABLE HERE" + " Here Are Your Options: ");
                                    // Change User to name in Databse
                                    System.out.println(" --------------------------------------------");

                                    System.out.println();
                                    String Send_Money = "1. Send Money";
                                    String Request_Funds = "2. Request Money";
                                    String Wallet_History = "3. Wallet Payment History ";
                                    String Account_info = "4. Account Information";
                                    String Exit = "5. Exit";

                                    System.out.printf(" %15s %15s %15s \n", Send_Money, Request_Funds, Wallet_History);
                                    System.out.printf("\n");
                                    System.out.printf("\t%18s%18s\n", Account_info, Exit);

                                    String User_Menu_Input = sc.nextLine();
                                    User_Options(User_Menu_Input );

                                }
                            }

                    } else {
                        System.out.println("Email Address Cannot be found");
                    }

                    con.close();

                } else{
                    System.out.println(" Invalid Input. Try Again!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


    }


public static void User_Options(String input){

        String [] options = {"1", "2", "3","4","5"};

        // If option is not in options array give error
        // If it is in the option array do switch case 

       // Switch Case on input
        // Take in User Input
        // Use a Switch Case



}



}
