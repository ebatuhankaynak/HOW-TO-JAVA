package com.mocha.Admin.controllers;

import com.mocha.Admin.Core;
import com.mocha.Admin.JsonListenerCapsule.JsonListener;
import com.mocha.Admin.JsonListenerCapsule.RequestTypes;
import com.mocha.Admin.models.Admin;
import com.mocha.Admin.models.requests.LoginRequest;
import com.mocha.Admin.models.requests.LoginResultRequest;
import com.mocha.Admin.models.results.LoginResults;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 28.3.2016.
 */

public class LoginController extends Controller implements Initializable{

    @FXML TextField usernameTF;
    @FXML PasswordField passwordTF;
    @FXML Hyperlink createAccount;

    // TODO: 17.4.2016 HOLD DA NAME AFTA LOGIN 
    public LoginController(){
        Core.JsonListenerManager.addJsonListener(RequestTypes.LOGIN_RESULT, new JsonListener<LoginResultRequest>() {
            @Override
            public void run(LoginResultRequest req) {
                LoginResults res = req.getResult();
                if (res == LoginResults.SUCCESS){
                    System.out.println("Login successfull");
                    Admin admin = req.getAdmin();
                    Core.Storage.setAdmin(admin);
                }
                else if (res == LoginResults.FAILURE) {
                    System.out.println("Login failed");
                }
            }
        });
    }

    @FXML
    private void onSignInButtonClick(MouseEvent mouseEvent){
        // TODO: 8.4.2016 UNCOMMENT THIS TO TEST SERVER 
        Core.SocketManager.sendMessageObject(RequestTypes.LOGIN, new LoginRequest(usernameTF.getText(), passwordTF.getText()));
        if (true) {
            goToScene("AdminPanel");
        }
    }

    @FXML
    private void onCreateAccountClick(MouseEvent mouseEvent)
    {
        goToScene("CreateAccount");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
