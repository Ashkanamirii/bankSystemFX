package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.DatabaseConnection;

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
        if (accountChoiceBox.getValue() == "CREDIT" && !salaryTextField.getText().isBlank())
            registerMessageLabel.setText("Customer has been registered CREDIT successfully!");
        else {
            registerMessageLabel.setText("For CREDIT account " +
                    "you must enter your salary! TRY AGAIN");
        }
        //registerMessageLabel.setText("Customer has been registered successfully!");
    }

    public void registerCustomer() {
        DatabaseConnection connectNow = new DatabaseConnection();

    }

}
