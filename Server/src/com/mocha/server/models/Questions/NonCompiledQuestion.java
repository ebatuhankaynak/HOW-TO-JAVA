package com.mocha.server.models.Questions;

import com.mocha.server.models.Questions.QuestionID;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * NonCompiledQuestion
 * Creates a non compiled question
 * v 1.0
 */
public class NonCompiledQuestion
{
    // Instance Variables
    private String question;
    private QuestionID id;
    private int coffeeBeansAwarded;
    private String answer;

    // Constructor
    public NonCompiledQuestion( String question, QuestionID id, int coffeeBeansAwarded, String answer)
    {
        this.question = question;
        this.id = id;
        this.coffeeBeansAwarded = coffeeBeansAwarded;
        this.answer = answer;
    }

    public int getCoffeeBeansAwarded()
    {
        return coffeeBeansAwarded;
    }

    public QuestionID getId()
    {
        return id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setCoffeeBeansAwarded( int coffeeBeansAwarded )
    {
        this.coffeeBeansAwarded = coffeeBeansAwarded;
    }

    public void setId( QuestionID id )
    {
        this.id = id;
    }

    public void setQuestion( String question )
    {
        this.question = question;
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


