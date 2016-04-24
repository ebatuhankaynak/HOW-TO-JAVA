package com.mocha.server.models.Questions;

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
    private int questionNumber;
    private int questionLevel;
    private String questionTopic;

    // Constructor

    private QuestionID(){

    }

    public QuestionID( int questionNumber, int questionLevel, String questionTopic)
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

    public String getQuestionTopic()
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

    public void setQuestionTopic( String questionTopic)
        {
            this.questionTopic = questionTopic;
        }

    }
