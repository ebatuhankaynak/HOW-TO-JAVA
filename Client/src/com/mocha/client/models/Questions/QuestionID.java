package com.mocha.client.models.Questions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * QuestionID
 * Creates an object holding information about the questions
 * v 1.0
 */
public class QuestionID
{
    // Instance Variables
    @JsonProperty
    private int questionNumber;
    private int questionLevel;
    private int questionTopic;

    // Constructor
    private QuestionID(){

    }

    public QuestionID( int questionNumber, int questionLevel, int questionTopic)
    {
        this.questionLevel = questionLevel;
        this.questionNumber = questionNumber;
        this.questionTopic = questionTopic;
    }

    // Getter and setter methods for getting and altering the variables
    public int getQuestionLevel()
    {
        return questionLevel;
    }

    public int getQuestionTopic()
        {
            return questionTopic;
        }

    public int getQuestionNumber()
        {
            return questionNumber;
        }

    public void setQuestionLevel( int questionLevel)
        {
            this.questionLevel = questionLevel;
        }

    public void setQuestionNumber( int questionNumber)
        {
            this.questionNumber = questionNumber;
        }

    public void setQuestionTopic( int questionTopic)
        {
            this.questionTopic = questionTopic;
        }

    }
