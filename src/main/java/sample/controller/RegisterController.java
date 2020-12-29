package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.account.AccountEnum;
import sample.customer.Customer;
import sample.util.Util;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-26
 * Time:  22:01
 * Project: bankSystemFX
 * Copyright: MIT
 */
public class RegisterController implements Initializable {
    public TextField personalNumberTextField;
    public DatePicker dateOfBirthBox;
    public Button closeButton;
    public Button registerButton;
    public TextField firstNameTextField;
    public TextField LastNameTextField;
    public ImageView registerImageView;
    public Label registerMessageLabel;
    public TextField salaryTextField;
    public ChoiceBox accountChoiceBox;
    Util u = new Util();
    ObservableList<String> accountChoice =
            FXCollections.observableArrayList("SAVING", "CURRENT", "CREDIT");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File registerImageFile = new File("Images/register.png");
        Image registerImage = new Image(registerImageFile.toURI().toString());
        registerImageView.setImage(registerImage);
        accountChoiceBox.setValue("SAVING");
        accountChoiceBox.setItems(accountChoice);
    }

    public void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void registerButtonAction(ActionEvent event) {
//        if (accountChoiceBox.getValue() == "CREDIT" && !salaryTextField.getText().isBlank()){
//            registerMessageLabel.setText("Customer has been registered CREDIT successfully!");
//        }
//        else {
//            registerMessageLabel.setText("For CREDIT account " +
//                    "you must enter your salary! TRY AGAIN");
//        }
        registerMessageLabel.setText("Customer has been registered CREDIT successfully!");
        registerCustomer();
        addParameter();
        //registerMessageLabel.setText("Customer has been registered successfully!");
    }

    public void registerCustomer() {
        u.registerNewCustomer(addParameter());
    }
    public Customer addParameter(){
        Customer customer = new Customer();
        customer.setFirstName(this.firstNameTextField.getText());
        customer.setLastName(LastNameTextField.getText());
        customer.setSalary(Double.parseDouble(salaryTextField.getText()));
        if (accountChoiceBox.getValue() == "SAVING")
        customer.setAccountType(AccountEnum.getAccountType(0));
        else if (accountChoiceBox.getValue() == "CURRENT")
            customer.setAccountType(AccountEnum.getAccountType(1));
        else if (accountChoiceBox.getValue() == "CREDIT")
            customer.setAccountType(AccountEnum.getAccountType(2));
        customer.setPersonalNumber(Long.valueOf(personalNumberTextField.getText()));
        customer.setDateOfBirth(dateOfBirthBox.getValue());
        return customer;
    }

}
