package ui.adminui;

import main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ui.common.Dialog;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    Dialog dialog = new Dialog();
    private MainApp application;

    public void setApp(MainApp application) {
        this.application = application;
    }

    @FXML
    static Button loginButton;

    @FXML
    static TextField idText;
    @FXML
    static PasswordField passwordField;


    @FXML
    public void loginButtonAction(ActionEvent e) {
        application.userLogin("jiang", "00000");
        dialog.infoDialog("Login Successfully.");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
