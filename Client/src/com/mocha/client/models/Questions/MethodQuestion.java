package com.mocha.client.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * Method Question
 * Info about class
 * v 1.0
 */
public class MethodQuestion extends CompiledQuestion
{

    // Constructor
    public MethodQuestion(String question, QuestionID id, int coffeeBeansAwarded, String[] testCases,
                          String[] testCaseAnswers, String codeSegment)
    {
        super(question, id, coffeeBeansAwarded, testCases, testCaseAnswers);

    }
}