package com.mocha.client.models.Questions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Hüseyin Ziya İmamoğlu
 * 19.04.2016
 * ${CLASS_NAME}
 * Info about class
 * v 1.0
 */
public class CompiledQuestionContainer
{
    // Instance Variables
    @JsonProperty
    private ArrayList<CompiledQuestion> questions;
    private String questionTopic;
    private String questionLevel;

    public ArrayList<CompiledQuestion> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<CompiledQuestion> questions)
    {
        this.questions = questions;
    }

    public String getQuestionTopic()
    {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic)
    {
        this.questionTopic = questionTopic;
    }

    public String getQuestionLevel()
    {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel)
    {
        this.questionLevel = questionLevel;
    }

    public void add ( CompiledQuestion question)
    {
        questions.add(question);
    }

    public CompiledQuestionContainer(){

    }

    // Constructor
    public CompiledQuestionContainer( String questionTopic, String questionLevel)
    {
        questions = new ArrayList<>();
        this.questionTopic = questionTopic;
        this.questionLevel = questionLevel;
    }


}