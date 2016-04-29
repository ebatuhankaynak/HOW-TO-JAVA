package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * CodeCompletionQuestion Class
 * Creates a code sompletion question
 * v 1.0
 */
public class CodeCompletionQuestion extends CompiledQuestion
{
    // Instance Variables
    private String codeSegment;

    // Constructor
    public CodeCompletionQuestion( String question, QuestionID id, int coffeeBeansAwarded, String[] testCases,
                                    String[] testCaseAnswers, String codeSegment, String testClass)
    {
        super( question, id, coffeeBeansAwarded, testCases, testCaseAnswers, testClass);
        this.codeSegment = codeSegment;
    }

    // Getter and setter methods
    public String getCodeSegment()
    {
        return codeSegment;
    }

    public void setCodeSegment(String codeSegment)
    {
        this.codeSegment = codeSegment;
    }
}
