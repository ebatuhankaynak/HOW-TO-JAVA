package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * NonCompiledQuestion
 * Creates a non compiled question
 * v 1.0
 */
public class NonCompiledQuestion extends Question
{
    // Instance Variables
    private String answer;

    // Constructor
    public NonCompiledQuestion( String question, QuestionID id, int coffeeBeansAwarded, String answer)
    {
        super( question, id, coffeeBeansAwarded);
        this.answer = answer;
    }

    // Check method
    public boolean check ( String userInput)
    {
        return userInput.equals( answer);
    }

    // Get and set methods
    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer( String answer)
    {
        this.answer = answer;
    }
}


