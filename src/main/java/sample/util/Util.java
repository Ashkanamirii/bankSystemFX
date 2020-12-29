package sample.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DatabaseConnection;
import sample.customer.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-28
 * Time:  23:18
 * Project: bankSystemFX
 * Copyright: MIT
 */
public class Util {
    //a method to generate a random number (ID, PIN, account number)
    public static int generateRandomNumber(int upperBound, int lowerBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }

    public  void loadViews(String FXMLFileName, Label logOutLabel){
        try {
            // Detta är för att stänga föregående scene och ladda en ny
            Stage stage = (Stage) logOutLabel.getScene().getWindow();
            stage.close();

            Parent userLogin = FXMLLoader.load(getClass().getClassLoader().getResource(FXMLFileName + ".fxml"));
            stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(userLogin));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getDateNowFormat() {
        LocalDateTime DateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return DateNow.format(formatter);
    }

    public void registerNewCustomer(Customer c) {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        int pin = generateRandomNumber(9000, 1000);
        c.setCustomerPinCode(pin);
        long accNr = 0;
        if (c.getAccountEnum().getAccountType() == 0)
            accNr = generateRandomNumber(17400000, 17300000);
        else if (c.getAccountEnum().getAccountType() == 1)
            accNr = generateRandomNumber(27400000, 27300000);
        else if (c.getAccountEnum().getAccountType() == 2)
            accNr = generateRandomNumber(37400000, 37300000);

        c.getAccount().setAccountNumber(accNr);
        System.out.println(c.getAccount().getAccountNumber());

        String custID = "SELECT customer_id FROM customer ORDER BY customer_id DESC limit 1";
        int cust_id = Integer.parseInt(custID);

        String customerInsert = "INSERT INTO customer(FIRST_NAME,LAST_NAME,PERSONAL_NUMBER,DATE_OF_BIRTH,SALARY,PIN_CODE) VALUES('"
                + c.getFirstName() + "','" + c.getLastName() + "','" + c.getPersonalNumber() + "','" + c.getDateOfBirth() + "','" + c.getSalary() + "','" + c.getCustomerPinCode() + "')";

        String accountInsert = "INSERT INTO account(ACCOUNT_NUMBER,BALANCE,CREAT_DATE,MODIFY_DATE,ACCOUNT_TYPE,customer_id) VALUES('"
                + c.getAccount().getAccountNumber() + "','" + 0 + "','" + getDateNowFormat() + "','" + getDateNowFormat() + "','" + c.getAccountEnum().getAccountType() + "','" + cust_id +
                "')";
        try {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(customerInsert);
            statement.executeUpdate(accountInsert);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
