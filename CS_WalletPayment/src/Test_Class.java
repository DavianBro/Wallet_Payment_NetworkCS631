import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util .*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql .*;

public class Test_Class extends Wallet_Methods  {

        public static void main(String[] args) throws Exception {

            //////////////////////////////////////////////////////////////////
            // to be customized according to your own devices
            String url = "jdbc:mysql://localhost:3306/WalletNetwork";
            String uname = "root"; //username I have set in my device, change to whatever you have set in your device
            String password = "Wallet_network631"; //password I have set in my device, change to whatever your password is
            ///////////////////////////////////////////////////////////////////

            //setting up connection with local database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, uname, password);


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

                if (Robot_verify.equals("1")) {

                    System.out.println(" 1.) Press 1 to Login");
                    System.out.println(" 2.) Press 2 to Create Account");

                } else {

                    System.out.println(" Access Denied to Wallet Payment Network. Please Try Again");


                }

                Scanner login = new Scanner(System.in);
                System.out.print("Please enter your email: ");
                String login_verify = login.next();

                Statement st = con.createStatement();
                ResultSet result = st.executeQuery("select EmailAdd from EMAIL;");

                while (result.next()) {
                    String email_verify = result.getString(1);
                    if (login_verify.equals(email_verify)) {
                        System.out.println("Thanks for logging in, welcome back");
                    }

                }


                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            /*
             * Once Logged in
             * Account info
             * Send money

             */


        }
    }

