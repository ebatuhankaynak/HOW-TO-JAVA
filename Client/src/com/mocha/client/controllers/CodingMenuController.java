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
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by E.Batuhan Kaynak on 8.4.2016.
 */

public class CodingMenuController extends Controller implements Initializable {

    @FXML Label questionTitle;
    @FXML Label questionLabel;
    @FXML TextArea codingArea;
    @FXML HTMLEditor htmlEditor;

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
        goToScene("CodingMenuTest");
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
        codingArea.setPromptText("Enter Your Code Here!");

        htmlEditor.lookup(".top-toolbar").setManaged(false);
        htmlEditor.lookup(".top-toolbar").setVisible(false);

        htmlEditor.lookup(".bottom-toolbar").setManaged(false);
        htmlEditor.lookup(".bottom-toolbar").setVisible(false);

        htmlEditor.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(getPageContents(htmlEditor.getHtmlText()));
                if(getPageContents(htmlEditor.getHtmlText()).contains("public")){
                    System.out.println("INSIDE IF");
                    String parsedHtml = getPageContents(htmlEditor.getHtmlText());
                    for (int i = 0; i + 6 <= parsedHtml.length(); i++){
                        System.out.println("INSIDE FOR");
                        if (parsedHtml.substring(i, i + 6).equals("public")){
                            htmlEditor.setHtmlText(parsedHtml.substring(0, i) + "<span style=\"color:blue;\">public</span>" + parsedHtml.substring(i + 6));
                            //htmlEditor.setHtmlText(parsedHtml.substring(0, i) + "<span style=\"color:blue;\">" + parsedHtml.substring(i, i + 6) + "</span>");
                        }
                    }

                    //htmlEditor.setHtmlText( parsedHtml.substring(0, parsedHtml.length() - 6) + "<span style=\"color:blue;\">public</span>");

                }
                //htmlEditor.setHtmlText( getPageContents(htmlEditor.getHtmlText()) + "<span style=\"color:red;\">sa</span>");
            }
        });
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