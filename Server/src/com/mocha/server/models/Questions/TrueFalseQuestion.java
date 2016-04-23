package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * TrueFalseQuestion
 * Creates a True False Question
 * v 1.0
 */
public class TrueFalseQuestion extends NonCompiledQuestion
{
    // Constructor
    public TrueFalseQuestion( String question, QuestionID id, int coffeeBeansAwarded,String answer)
    {
        super( question, id, coffeeBeansAwarded,answer);
    }

}
