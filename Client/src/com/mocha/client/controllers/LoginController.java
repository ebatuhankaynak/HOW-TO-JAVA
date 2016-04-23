package com.mocha.client.controllers;

import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.requests.LoginRequest;
import com.mocha.client.models.requests.LoginResultRequest;
import com.mocha.client.models.results.LoginResults;
import com.mocha.client.models.User;
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
                    User user = req.getUser();
                    System.out.println(user.getUsername());
                    Core.Storage.setUser(user);
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
            goToScene("MainMenu");
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
