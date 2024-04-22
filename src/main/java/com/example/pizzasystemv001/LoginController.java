package com.example.spring24swe3313pizzalogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;


    @FXML //Switches to the Signup scene when "register now" button is clicked
    public void loadSignup(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("Signup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /*private void loadSignup () throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("Signup.fxml"));
        Pane signupPane = (Pane) fxmlLoader.load();
        try {
            anchorPane.getChildren().clear();;
            anchorPane.getChildren().add(signupPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    //----------------- Allows for user to register their information-------------------------------------\
    @FXML
    private TextField userFirstName;
    @FXML
    private TextField userLastName;
    @FXML
    private TextField userPhoneNumber;
    @FXML
    private TextField userPassword;
    @FXML
    private Button userRegister;

    public void userRegister(ActionEvent event){
        String stringUserFirstName = userFirstName.getText();
        String stringUserLastName = userLastName.getText();
        String stringUserPhoneNumber = userPhoneNumber.getText();
        String stringUserPassword = userPassword.getText();


    }

}