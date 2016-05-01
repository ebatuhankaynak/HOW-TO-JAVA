package com.mocha.server.listeners;

import com.mocha.server.Core;
import com.mocha.server.JsonListenerCapsule.JsonListener;
import com.mocha.server.JsonListenerCapsule.RequestTypes;
import com.mocha.server.models.Questions.CompiledQuestionContainer;
import com.mocha.server.models.requests.QuestionRequest;
import com.mocha.server.models.requests.QuestionResultRequest;
import com.mocha.server.models.results.QuestionResults;

/**
 * Created by E.Batuhan Kaynak on 19.4.2016.
 */
public class QuestionListener extends JsonListener<QuestionRequest> {

    @Override
    public void run(QuestionRequest req) {
        QuestionResults res;
        CompiledQuestionContainer container;
        if (Core.Repository.getQuestionContainers().find(req) != null){
            res = QuestionResults.SUCCESS;
        }
        else{
            res = QuestionResults.FAILURE;
        }

        container = Core.Repository.getQuestionContainers().find(req);

        System.out.print(container.getQuestions().get(0).getQuestion());

        Core.ServerManager.sendMessageObject(getClientUID(), RequestTypes.QUESTION_RESULT, new QuestionResultRequest(res, container));
        System.out.println("Sent question with " + res);

    }
}
