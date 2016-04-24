package com.mocha.client.models.requests;

import com.mocha.client.models.results.QuestionResults;
import com.mocha.client.models.Questions.QuestionContainer;

/**
 * Created by E.Batuhan Kaynak on 19.4.2016.
 */
public class QuestionResultRequest {
    private QuestionResults result;
    private QuestionContainer questions;

    public QuestionResultRequest(QuestionResults result) {
        this.result = result;
    }

    public QuestionResults getResult() {
        return result;
    }

    public void setResult(QuestionResults result) {
        this.result = result;
    }

    public QuestionContainer getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionContainer questions) {
        this.questions = questions;
    }
}
