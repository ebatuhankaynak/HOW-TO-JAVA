package com.mocha.server.models.requests;

import com.mocha.server.models.Questions.CompiledQuestionContainer;
import com.mocha.server.models.results.QuestionResults;

/**
 * Created by E.Batuhan Kaynak on 19.4.2016.
 */
public class QuestionResultRequest {
    private QuestionResults result;
    private CompiledQuestionContainer questions;

    public QuestionResultRequest(QuestionResults result, CompiledQuestionContainer questions) {
        this.result = result;
        this.questions = questions;
    }

    public QuestionResults getResult() {
        return result;
    }

    public void setResult(QuestionResults result) {
        this.result = result;
    }

    public CompiledQuestionContainer getQuestions() {
        return questions;
    }

    public void setQuestions(CompiledQuestionContainer questions) {
        this.questions = questions;
    }
}
