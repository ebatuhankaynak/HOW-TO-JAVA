package com.mocha.client.controllers;


import com.mocha.client.Core;
import com.mocha.client.JsonListenerCapsule.JsonListener;
import com.mocha.client.JsonListenerCapsule.RequestTypes;
import com.mocha.client.models.Questions.CompiledQuestion;
import com.mocha.client.models.Questions.Question;
import com.mocha.client.models.requests.CompileRequest;
import com.mocha.client.models.requests.CompileResultRequest;
import com.mocha.client.models.results.CompileResults;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class CodingMenuController extends Controller implements Initializable {

    @FXML Label questionTitle;
    @FXML Label questionLabel;
    @FXML Label awardLabel;
    @FXML TextArea codingArea;
    @FXML ProgressBar progressBar;
    //@FXML HTMLEditor htmlEditor;
    //@FXML WebView webView;

    private Question question;

    public CodingMenuController(){
        question = Core.Storage.getQuestionToShow();

        Core.JsonListenerManager.addJsonListener(RequestTypes.COMPILE_RESULT, new JsonListener<CompileResultRequest>() {
            @Override
            public void run(CompileResultRequest req) {
                System.out.println("IN CODING MENU");
                CompileResults res = req.getResult();
                System.out.println(res);
                if (res == CompileResults.SUCCESS) {
                    Core.Storage.setCompileResultRequest(req);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            goToScene("CodingMenuTest");
                        }
                    });
                } else if (res == CompileResults.FAILURE) {
                    System.out.println("Rip Compile");
                }
            }
        });
    }

    @FXML
    public void onCompileButtonClick(MouseEvent mouseEvent)
    {
        sendCodeToServer();
    }

    public void sendCodeToServer()
    {
        String userName = Core.Storage.getUser().getUsername();
        String codeToSend = codingArea.getText();
        progressBar.setVisible(true);
        Core.Storage.setCodeToShow(codeToSend);
        Core.SocketManager.sendMessageObject(RequestTypes.COMPILE, new CompileRequest(codeToSend ,userName, question));
    }

    @FXML
    public void onTopicMenuButtonClick(MouseEvent mouseEvent)
    {
        goToScene("TopicMenu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Question question = Core.Storage.getQuestionToShow();
        questionLabel.setText(question.getQuestion());
        awardLabel.setText("Coffee Bean award: " + String.valueOf(question.getCoffeeBeansawarded()));
        codingArea.setText("public static int factorial (int n){\n" +
                "\tif (n <= 1)\n" +
                "\treturn 1;\n" +
                "\treturn n * factorial (n - 1);\n" +
                "}");
    }

    public String getBluePublic(String parsedHtml){
        if (parsedHtml.contains("public")) {
            for (int i = 0; i + 6 <= parsedHtml.length(); i++) {
                if (parsedHtml.substring(i, i + 6).equals("public")) {
                    return parsedHtml.substring(0, i) + "<span style='color:blue;'>public</span>" + getBluePublic(parsedHtml.substring(i + 6));
                }
            }
            return parsedHtml;
        }
        else {
            return parsedHtml;
        }
    }

    public String getPageContents(String content)
    {
        String result = "";
        boolean htmlFound;
        boolean andFound;
        htmlFound = false;
        andFound = false;
        for (int i = 0; i < content.length(); i++)
        {
            if (content.charAt(i) == '<')
            {
                htmlFound = true;
            }
            else if (content.charAt(i) == '&')
            {
                andFound = true;
            }
            if (!htmlFound && !andFound)
            {
                result = result + content.charAt(i);
            }
            if (content.charAt(i) == '>')
            {
                htmlFound = false;
            }
            else if (content.charAt(i) == ';')
            {
                andFound = false;
            }
        }
        return result;
    }
}

        /*
        webView.lookup(".top-toolbar").setManaged(false);
        webView.lookup(".top-toolbar").setVisible(false);

        webView.lookup(".bottom-toolbar").setManaged(false);
        webView.lookup(".bottom-toolbar").setVisible(false);
        */