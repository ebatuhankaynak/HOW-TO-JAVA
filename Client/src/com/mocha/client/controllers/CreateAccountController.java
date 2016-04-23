package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.requests.RegisterRequest;
import com.mocha.client.models.requests.RegisterResultRequest;
import javafx.fxml.FXML;
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

    public CreateAccountController(){
        Core.JsonListenerManager.addJsonListener(RequestTypes.REGISTER_RESULT, new JsonListener<RegisterResultRequest>() {

            @Override
            public void run(RegisterResultRequest req) {

                System.out.println(req.getResult());

            }

        });
    }
    public void onCreateAccountClick(MouseEvent event) {
        if (passwordTF.getText().equals(rePasswordTF.getText()))
        {

            Core.SocketManager.sendMessageObject(RequestTypes.REGISTER, new RegisterRequest(usernameTF.getText(), passwordTF.getText()));
            //goToScene("");
        }
        else
        {
            // TODO: 31.3.2016 DİYALOG GÖSTER EŞİT DEĞİL
            System.out.println("Passwords not equal");
        }
    }

    public void onSignInClick(MouseEvent event) {
        goToScene("LoginScreen");
    }
}
