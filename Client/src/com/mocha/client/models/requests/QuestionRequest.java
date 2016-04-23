package com.mocha.client.models.requests;

/**
 * Hüseyin Ziya İmamoğlu && Hüseyin Elmas
 * 17.04.2016
 * Question Request
 * Creates a question request
 * v 1.0
 */
public class QuestionRequest
{
    // Instance Variables
    private String questionTopic;
    private String questionLevel;

    // Constructors
    public QuestionRequest(String questionTopic, String questionLevel)
    {
        this.questionLevel = questionLevel;
        this.questionTopic = questionTopic;
    }

    public String toSearchQuery()
    {
        return "{ questionTopic: '" + questionTopic + "', questionLevel: '" + questionLevel + "' }";
    }

    public void setQuestionTopic(String questionTopic)
    {
        this.questionTopic = questionTopic;
    }

    public void setQuestionLevel(String questionLevel)
    {
        this.questionLevel = questionLevel;
    }
}

