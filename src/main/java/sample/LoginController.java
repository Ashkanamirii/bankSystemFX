package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
            loginMessageLabel.setText("You try to login");
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

    }
    public void registerButtonAction(ActionEvent event){
        creatAccount();
    }

    public void creatAccount(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 600, 535));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
