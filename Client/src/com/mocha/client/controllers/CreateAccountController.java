package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.requests.RegisterRequest;
import com.mocha.client.models.requests.RegisterResultRequest;
import com.mocha.client.models.results.RegisterResults;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Created by E.Batuhan Kaynak on 31.3.2016.
 */

public class CreateAccountController extends Controller {

    @FXML TextField usernameTF;
    @FXML PasswordField passwordTF;
    @FXML PasswordField rePasswordTF;
    @FXML Label errorLabel;

    public CreateAccountController(){
        Core.JsonListenerManager.addJsonListener(RequestTypes.REGISTER_RESULT, new JsonListener<RegisterResultRequest>() {
            @Override
            public void run(RegisterResultRequest req) {
                RegisterResults res = req.getResult();
                System.out.println(res);
                if (res == RegisterResults.SUCCESS){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("LoginScreen");
                        }
                    });
                }
                else{
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            errorLabel.setText("Username Exists!");
                        }
                    });
                }
            }
        });
    }

    public void onCreateAccountClick(MouseEvent event) {
        if (passwordTF.getText().equals(rePasswordTF.getText()))
        {
            Core.SocketManager.sendMessageObject(RequestTypes.REGISTER, new RegisterRequest(usernameTF.getText(), passwordTF.getText()));
        }
        else
        {
            errorLabel.setText("Passwords do not match:(");
            System.out.println("Passwords not equal");
        }
    }

    public void onSignInClick(MouseEvent event) {
        goToScene("LoginScreen");
    }
}
