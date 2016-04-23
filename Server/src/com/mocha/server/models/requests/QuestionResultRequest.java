package com.mocha.server.models.requests;

import com.mocha.server.models.Questions.QuestionContainer;
import com.mocha.server.models.results.QuestionResults;
import com.mocha.server.models.Questions.Question;

import java.util.List;

/**
 * Created by E.Batuhan Kaynak on 19.4.2016.
 */
public class QuestionResultRequest {
    private QuestionResults result;
    private QuestionContainer questions;

    public QuestionResultRequest(QuestionResults result, QuestionContainer questions) {
        this.result = result;
        this.questions = questions;
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
