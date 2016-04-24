package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * CompiledQuestion
 * Creates a compiled question
 * v 1.0
 */
public class CompiledQuestion extends Question
{
    // Instance Variables
    private String[] testCases;
    private String[] testCaseAnswers;
    private String testClass;

    // Constructor
    public CompiledQuestion( String question, QuestionID id, int coffeeBeansAwarded,
                            String[] testCases, String[] testCaseAnswers, String testClass)
    {
        super( question, id, coffeeBeansAwarded);
        this.testCases = testCases;
        this.testCaseAnswers = testCaseAnswers;
        this.testClass = testClass;
    }

    // Check Method
    public boolean[] check( String[] results)
    {
        boolean[] result;

        result = new boolean[testCaseAnswers.length];
        for (int i = 0; i < testCaseAnswers.length; i++)
        {
            result[i] = ( testCaseAnswers[i].equals( results[i]));
        }
        return result;
    }

    // Getter and setter methods
    public void setTestCases(String[] testCases)
    {
        this.testCases = testCases;
    }

    public String[] getTestCases()
    {
        return testCases;
    }

    public String getTestClass(){
        return testClass;
    }





}



