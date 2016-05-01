package com.mocha.client.models;

import com.mocha.client.models.Questions.CompiledQuestionContainer;

/**
 * Created by Mert on 29.04.2016.
 */
public class DiagnosticTest
{
    // Instance Variables
    private CompiledQuestionContainer compiledQuestions;

    // Constructor
    public DiagnosticTest()
    {
        compiledQuestions = new CompiledQuestionContainer();
    }

    // Getter and setter methods
    public CompiledQuestionContainer getCompiledQuestions()
    {
        return compiledQuestions;
    }

    public void setCompiledQuestions( CompiledQuestionContainer compiledQuestions )
    {
        this.compiledQuestions = compiledQuestions;
    }


}


