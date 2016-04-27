package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * Tracing Question
 * Creates a Tracing Question
 * v 1.0
 */
public class TracingQuestion extends NonCompiledQuestion
{
    // Instance Variables
    private String codeSegment;

    // Constructor
    public TracingQuestion( String question, QuestionID id, int coffeeBeansAwarded, String answer, String codeSegment, String testClass)
    {
        super( question, id, coffeeBeansAwarded, answer);
        this.codeSegment = codeSegment;
    }

    // Getter ans setter methods

    public String getCodeSegment()
    {
        return codeSegment;
    }

    public void setCodeSegment(String codeSegment)
    {
        this.codeSegment = codeSegment;
    }
}
