package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * TestCaseQuestion
 * Creates a test case question
 * v 1.0
 */
public class TestCaseQuestion extends CompiledQuestion
{
    // Instance Variables
    private String codeSegment;

    // Constructor
    public TestCaseQuestion( String question, QuestionID id, int coffeeBeansAwarded,
                             String[] testCases, String[] testCaseAnswers, String codeSegment, String testClass)
    {
        super( question, id, coffeeBeansAwarded, testCases, testCaseAnswers, testClass);
        this.codeSegment = codeSegment;
    }

    // Getter and setter methods
    public void setCodeSegment(String codeSegment)
    {
        this.codeSegment = codeSegment;
    }

    public String getCodeSegment()
    {
        return codeSegment;
    }
}
