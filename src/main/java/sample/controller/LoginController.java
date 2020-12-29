package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.DatabaseConnection;
import sample.util.Util;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Button loginButton;
    public Button registerButton;
    public Label loginMessageLabel;
    public Button cancelButton;
    public PasswordField enterPasswordField;
    public TextField enterUserNameField;
    public ImageView lockImageView;
    public ImageView ashkanBankImageView;
    Util u = new Util();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File ashkanBankImageFile = new File("Images/AshkanBank.jpeg");
        Image ashkanBankImage = new Image(ashkanBankImageFile.toURI().toString());
        ashkanBankImageView.setImage(ashkanBankImage);

        File lockImageFile = new File("Images/lock.png");
        Image lockImage = new Image(lockImageFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event) {

        if(!enterUserNameField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            //loginMessageLabel.setText("You try to login");
            validLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validLogin(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String verifyLogin = "SELECT count(1) FROM customer WHERE personal_number = '"
                + enterUserNameField.getText() + "' AND pin_code ='"
                + enterPasswordField.getText() + "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Congratulation");
                    //TODO: creat main menu
                    //mainMenu();
                }else {
                    loginMessageLabel.setText("Invalid login. please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void registerButtonAction(ActionEvent event){
        u.loadViews("register", loginMessageLabel);
    }
}
