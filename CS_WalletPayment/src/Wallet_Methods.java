import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Wallet_Methods extends dbconnect {

    static Scanner sc = new Scanner(System.in);
    static String name;


    public static void login_verification(String x) throws Exception {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, password);

            if (x.equals("1")) {

                System.out.println("Enter Email Address");

                // Declare and Store Email Address Variable
                String Email_Address = sc.nextLine();

                Statement st = con.createStatement();
                // ResultSet result = st.executeQuery("select EmailAdd from EMAIL where EmailAdd ='"+ Email_Address + "';");
                ResultSet result = st.executeQuery("select * from EMAIL where EmailAdd ='" + Email_Address + "';");

                // if email == null then

                if (result.next()) {

                    // Had to remove while LOOP was giving error
                    String email_verify = result.getString(1);

                    if (Email_Address.equals(email_verify)) {

                        //gets SSN from column 2 of EMAIL table
                        String ssn_verify = result.getString(2);
                        //Pass SSN into select * from USER_ACCOUNT where SSN=' '
                        Statement xy = con.createStatement();
                        ResultSet name_Result = xy.executeQuery("select * from USER_ACCOUNT where SSN='" + ssn_verify + "';");

                        while (name_Result.next()) {
                            //USER_ACCOUNT DATA
                            //NAME
                            String name = name_Result.getString(2);
                            //PhoneNo
                            String phoneno = name_Result.getString(3);
                            //Balance
                            String balance = name_Result.getString(4);
                            //BankID
                            String bankid = name_Result.getString(5);
                            //BANumber
                            String banumber = name_Result.getString(6);
                            //PBAVerified
                            String pbaverified = name_Result.getString(7);

                            System.out.println("User Email " + Email_Address + " Identified in Database, Please Enter Password");
                            System.out.println();
                            System.out.println("Enter Password");
                            String Login_Password = sc.nextLine();

                            if (Login_Password.equals("0631")) { // and equals an email in the database
                                System.out.println();
                                System.out.println();
                                UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);

                            }
                        }
                    } // while loop bracket


                } else {
                    System.out.println("Email Address Cannot be found");
                }

                con.close();

            } else {
                System.out.println(" Invalid Input. Try Again!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void UserInput(String name, String ssn_verify, String phoneno, String balance, String bankid, String banumber, String pbaverified, String email_verify) throws SQLException {
        System.out.println("Welcome Back " + name + " Here Are Your Options: ");


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


        if (User_Menu_Input.equals("1")) {
            System.out.println("SEND MONEY");
            System.out.println("--------------------");
            System.out.println("Welcome, " + name);
            //- db connection
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement ab = con.createStatement();
            //user input
            System.out.println("Enter the PHONE NUMBER of the Recipient:");
            // Declare and Store recipient Variable (Identifier)
            String recipient = sc.nextLine();
            //user input
            System.out.println("Enter Amount to Send:");
            // Declare and Store sendamount Variable
            String sendamount = sc.nextLine();
            //user input
            System.out.println("Enter Memo:");
            // Declare and Store sendamount Variable
            String memo = sc.nextLine();
            //date
            // Declare Time and Date
            LocalDateTime now = LocalDateTime.now();
            // Format Date and Time
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //Alter the object now to format
            String formatDateTime = now.format(format);
            //query 1-- UPDATE SEND_TRANSACTION
            String sendSql = ("INSERT INTO SEND_TRANSACTION (Amount,Memo,Date_Time, Identifier,SSN) VALUES ('" + sendamount + "','" + memo + "','" + formatDateTime + "','" + recipient + "','" + ssn_verify + "');");
            //query 2-- update recipient balance
            String sendSql2 = ("UPDATE WalletNetwork.USER_ACCOUNT SET Balance = Balance+" + sendamount + " WHERE PhoneNo='" + recipient + "';");
            //query 2-- update recipient balance
            String sendSql3 = ("UPDATE WalletNetwork.USER_ACCOUNT SET Balance = Balance-" + sendamount + " WHERE SSN='" + ssn_verify + "';");

            //SEND STATEMENTS TO SQL
            ab.executeUpdate(sendSql);
            ab.executeUpdate(sendSql2);
            ab.executeUpdate(sendSql3);
            //RECEIPT
            System.out.print("Sending Money to:  " + recipient + "\n");
            System.out.print("\n" + "-------------------------------" + "\n");
            System.out.print("PAYMENT RECEIPT:" + "\n");
            System.out.print("Amount: $" + sendamount + "\n");
            System.out.print("Recipient: " + recipient + "\n");
            System.out.print("Memo: " + memo + "\n");
            System.out.print("Date/Time: " + formatDateTime + "\n");
            System.out.print("-------------------------------" + "\n");

            //back to menu
            UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            ///
        } else if (User_Menu_Input.equals("2")) {
            System.out.println("REQUEST MONEY");
            System.out.println("--------------------");
            //
            //- db connection
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement ab = con.createStatement();
            //user input
            System.out.println("Enter Phone Number to request payment from user:");
            // Declare and Store recipient Variable (Identifier)
            String recipientreq = sc.nextLine();
            //user input
            System.out.println("Enter Amount to Request:");
            // Declare and Store request amount Variable
            String amountreq = sc.nextLine();
            //user input
            System.out.println("Enter Memo:");
            // Declare and Store memo Variable
            String memo1 = sc.nextLine();
            //date
            // Declare Time and Date
            LocalDateTime now = LocalDateTime.now();
            // Format Date and Time
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //Alter the object now to format
            String formatDateTime1 = now.format(format1);

            //query 1-- UPDATE REQUEST_TRANSACTION
            String requestSql = ("INSERT INTO REQUEST_TRANSACTION (Amount,Date_Time,Memo,SSN) VALUES ('" + amountreq + "','" + formatDateTime1 + "','" + memo1 + "','" + ssn_verify + "');");
            //SEND STATEMENTS TO SQL
            ab.executeUpdate(requestSql);

            //query request_transaction to find rtid
            ResultSet rtidresult = ab.executeQuery("SELECT * FROM REQUEST_TRANSACTION where SSN='" + ssn_verify + "' AND Amount='" + amountreq + "';");

            String rtidcheck = null;
            if (rtidresult.next()) {
                rtidcheck = rtidresult.getString(1);
                String transfrom = ("INSERT INTO TRANS_FROM (RTid, Identifier, Percentage) VALUES ('" + rtidcheck + "','" + recipientreq + "','100');");
                ab.executeUpdate(transfrom);
            }
            //RECEIPT
            System.out.println("REQUEST TRANSACTION RECEIPT" + "\n");
            System.out.println("----------------------------" + "\n");
            System.out.println("Request Transaction ID: #" + rtidcheck + "\n");
            System.out.println("Request from: " + email_verify + "\n");
            System.out.println("Request to user address: " + recipientreq + "\n");
            System.out.println("Amount requested: $" + amountreq + "\n");
            System.out.println("Memo: " + memo1 + "\n");
            System.out.println("Date/Time: " + formatDateTime1 + "\n");
            System.out.println("----------------------------" + "\n");
            //back to menu
            UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            /////
        } else if (User_Menu_Input.equals("3")) {
            System.out.println("Wallet Payment History");
            System.out.println("--------------------");
            //- db connection
            Connection con2 = DriverManager.getConnection(url, uname, password);
            //try
            String transid3, Amount3, datetime3, Memo3, CancelReason3, Identifier3, SSN3;

            PreparedStatement pstmt;
            ResultSet rs;
            //pstmt = con2.prepareStatement("SELECT * FROM SEND_TRANSACTION where SSN='" + ssn_verify + "';");
            pstmt = con2.prepareStatement("SELECT * FROM SEND_TRANSACTION where SSN=?;");
            // Create a PreparedStatement object    1

            pstmt.setString(1, ssn_verify);      // Assign value to input parameter      2

            rs = pstmt.executeQuery();        // Get the result table from the query  3
            while (rs.next()) {               // Position the cursor                  4
                transid3 = rs.getString(1);        // Retrieve the first column value
                Amount3 = rs.getString(2);      // Retrieve the first column value
                datetime3 = rs.getString(3);        // Retrieve the first column value
                Memo3 = rs.getString(4);      // Retrieve the first column value
                CancelReason3 = rs.getString(5);        // Retrieve the first column value
                Identifier3 = rs.getString(6);      // Retrieve the first column value
                SSN3 = rs.getString(7);      // Retrieve the first column value
                System.out.println("--------------------");
                System.out.println("SEND RECEIPT: #" + transid3);
                System.out.println("Send Transaction ID: " + transid3);
                System.out.println("Amount: " + Amount3);
                System.out.println("Date/Time: " + datetime3);
                System.out.println("Memo: " + Memo3);
                System.out.println("Cancel Reason: " + CancelReason3);
                System.out.println("Sent to: " + Identifier3);
                System.out.println("Sender SSN: " + SSN3);
                System.out.println("--------------------");
                // Print the column values
            }
            rs.close();                       // Close the ResultSet                  5
            pstmt.close();                    // Close the PreparedStatement


            PreparedStatement pstmt1;
            ResultSet rs1;

            pstmt1 = con2.prepareStatement("SELECT R.Amount, R.Date_Time, R.Memo,R.SSN, T.Identifier, R.RTid FROM REQUEST_TRANSACTION as R inner join TRANS_FROM as T on R.RTId = T.RTId WHERE SSN=?;");
            // Create a PreparedStatement object    1
            pstmt1.setString(1, ssn_verify);      // Assign value to input parameter      2

            rs1 = pstmt1.executeQuery();        // Get the result table from the query  3
            while (rs1.next()) {               // Position the cursor                  4
                String rtid4 = rs1.getString(6);      // Retrieve the first column value
                String amountrequested4 = rs1.getString(1);        // Retrieve
                String datetime4 = rs1.getString(2);      // Retrieve
                String Memo4 = rs1.getString(3);      // Retrieve
                String SSN4 = rs1.getString(4);        // Retrieve
                Identifier3 = rs1.getString(5);      // Retrieve

                System.out.println("--------------------");
                System.out.println("REQUEST RECEIPT: #" + rtid4);
                System.out.println("Request Transaction ID: " + rtid4);
                System.out.println("Date/Time: " + datetime4);
                System.out.println("Amount Requested: " + amountrequested4);
                System.out.println("Date/Time: " + datetime4);
                System.out.println("Memo: " + Memo4);
                System.out.println("Requester SSN: " + SSN4);
                System.out.println("Request sent to:  " + Identifier3);
                System.out.println("--------------------");

            }
            rs1.close();                       // Close the ResultSet                  5
            pstmt1.close();

            // Print the column values
            UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);

        } else if (User_Menu_Input.equals("4")) {
            System.out.println("ACCOUNT INFORMATION");
            System.out.println("--------------------");
            System.out.println("Name: " + name);
            System.out.println("SSN: " + ssn_verify);
            System.out.println("Phone Number: " + phoneno);
            System.out.println("Balance: $" + balance);
            System.out.println("Bank ID: " + bankid);
            System.out.println("Bank Account Number: " + banumber);
            System.out.println("PBA Verified: " + pbaverified);
            System.out.println("--------------------");

            //- db connection
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement ab = con.createStatement();
            System.out.println(" --------------------------------------------");
            System.out.println("Do you want to update your details?");

            System.out.println();
            String Update_name = "1. Update name"+"\n";
            String Update_phone = "2. Add/Update phone number"+"\n";
            //String update_email = "3. Update email ";
            String email_add = "3. Add email"+"\n";
            String bank_add = "4. Add bank account"+"\n";
            String no = "5. Back to Main Menu"+"\n";

            System.out.printf(Update_name);
            System.out.printf(Update_phone);
            System.out.printf(email_add);
            System.out.printf(bank_add);
            System.out.printf(no);
            System.out.println(" --------------------------------------------");

            String user_update = sc.nextLine();
            if (user_update.equals("1")) {//update name
                System.out.println("Enter the name you wish to change to:");
                // Declare and Store new name
                String name_change = sc.nextLine();
                //query 1-- UPDATE name
                String name_sql = ("update USER_ACCOUNT set Name = '" + name_change + "' where SSN = '" + ssn_verify + "';");
                //SEND STATEMENTS TO SQL
                ab.executeUpdate(name_sql);
                System.out.println("Your name has been updated");
                System.out.println(" --------------------------------------------");
                UserInput(name_change, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            } else if (user_update.equals("2")) {//update phone number
                System.out.print("Enter the phone number you wish to change to: ");
                // Declare and Store new name
                String phone_number = sc.nextLine();

                String phone_updated = ("insert into ELEC_ADDRESS (Identifier, Verified, Type) Values ('" + phone_number + "','False','Phone');");
                //SEND STATEMENTS TO SQL
                ab.executeUpdate(phone_updated);

                String phone_updated2 = ("update USER_ACCOUNT set PhoneNo = '" + phone_number + "' where SSN = '" + ssn_verify + "';");
                //SEND STATEMENTS TO SQL
                ab.executeUpdate(phone_updated2);
                System.out.println("Your Phone number " + phone_number + " has been updated in the database");
                System.out.println(" --------------------------------------------");
                UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            } //else if (user_update.equals("3")) {//update email
            // System.out.print("Enter the email you wish to change to: ");
            // Declare and Store new name
            //String email_updated = sc.nextLine();

//                String phone_updated= ("insert into ELEC_ADDRESS (Identifier, Verified, Type) values ('" + email_updated + "','False','Email');");
//                //String phone_updated= ("insert into ELEC_ADDRESS (Identifier, Verified, Type) values ('" + email_updated + "','False','Email');");
//                //SEND STATEMENTS TO SQL
//                ab.executeUpdate(phone_updated);
            //String phone_updated4= ("update WalletNetwork.ELEC_ADDRESS set Identifier = '" + email_updated + "' where Identifier ='" + email_verify + "';");
            //String phone_updated3= ("update WalletNetwork.EMAIL set EmailAdd = '" + email_updated + "' where SSN ='" + ssn_verify + "';");


            //String phone_updated2= ("insert into EMAIL (EmailAdd, SSN) values ('" + email_updated + "','" + ssn_verify + "');");
            //SEND STATEMENTS TO SQL
            //ab.executeUpdate(phone_updated4);
            //ab.executeUpdate(phone_updated3);
            //System.out.println("Your email: " + email_updated + " has been updated in the database");
            //System.out.println(" --------------------------------------------");
            //UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            else if (user_update.equals("4")) {//Add email
                System.out.print("Enter the email you wish to add: ");
                // Declare and Store new name
                String email_updated = sc.nextLine();

                String phone_updated = ("insert into ELEC_ADDRESS (Identifier, Verified, Type) values ('" + email_updated + "','False','Email') where Identifier='" + phoneno + "';");
                //SEND STATEMENTS TO SQL
                //ab.executeUpdate(phone_updated);

                String phone_updated2 = ("insert into EMAIL (EmailAdd, SSN) values ('" + email_updated + "','" + ssn_verify + "');");
                //SEND STATEMENTS TO SQL

                ab.executeUpdate(phone_updated);
                ab.executeUpdate(phone_updated2);
                //ab.executeUpdate(phone_updated2);
                System.out.println("Your email: " + email_updated + " has been updated in the database");
                System.out.println(" --------------------------------------------");
                UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            } else if (user_update.equals("5")) {//add bank account
                System.out.print("Enter the bank account you wish to add: ");
                // Declare and Store new name
                String bank_account = sc.nextLine();

                String bank_up = ("insert into BANK_ACCOUNT (BANumber) values ('" + bank_account + "');");
                //SEND STATEMENTS TO SQL
                ab.executeUpdate(bank_up);

                String bank_up2 = ("insert into HAS_ADDITIONAL (SSN, BANumber, Verified) values ('" + ssn_verify + "','" + bank_account + "', 'True');");
                //SEND STATEMENTS TO SQL
                ab.executeUpdate(bank_up2);
                System.out.println("You have successfully added another bank account");
                System.out.println(" --------------------------------------------");
                UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);
            } else if (user_update.equals("6")) { //return to main menu
                UserInput(name, ssn_verify, phoneno, balance, bankid, banumber, pbaverified, email_verify);


            } else if (User_Menu_Input.equals("5")) {
                System.out.println("Thank You! Hope to see you soon :) ");
                System.exit(0);
            }
        }
    }
}
//}
