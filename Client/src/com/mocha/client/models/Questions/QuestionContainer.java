package com.mocha.client.models.Questions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mocha.server.models.Questions.Question;

import java.util.ArrayList;

/**
 * Hüseyin Ziya İmamoğlu
 * 19.04.2016
 * ${CLASS_NAME}
 * Info about class
 * v 1.0
 */
public class QuestionContainer
{
    // Instance Variables
    private ArrayList<Question> questions;
    private String questionTopic;
    private String questionLevel;

    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions)
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

    public void add ( Question question)
    {
        questions.add( question);
    }

    public QuestionContainer(){

    }

    // Constructor
    public QuestionContainer( String questionTopic, String questionLevel)
    {
        questions = new ArrayList<>();
        this.questionTopic = questionTopic;
        this.questionLevel = questionLevel;
    }


}