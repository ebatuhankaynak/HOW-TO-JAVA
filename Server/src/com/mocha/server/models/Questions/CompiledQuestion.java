package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * CompiledQuestion
 * Creates a compiled question
 * v 1.0
 */
public class CompiledQuestion
{
    // Instance Variables
    private String[] testCases;
    private String testClass;
    private QuestionID id;
    String question;
    int coffeeBeansAwarded;
    String[] testCaseAnswers;
    // Constructor
    public CompiledQuestion( String question, QuestionID id, int coffeeBeansAwarded,
                            String[] testCases, String[] testCaseAnswers, String testClass)
    {
        this.testClass = testClass;
        this.coffeeBeansAwarded = coffeeBeansAwarded;
        this.question = question;
        this.testCaseAnswers = testCaseAnswers;
        this.id = id;
        this.testCases = testCases;
        this.testCaseAnswers = testCaseAnswers;
    }
    public CompiledQuestion(){}

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


    public String[] getTestCaseAnswers() {
        return testCaseAnswers;
    }
    public String getQuestion(){
        return question;
    }
    public void setTestCaseAnswers(String[] testCaseAnswers) {
        this.testCaseAnswers = testCaseAnswers;
    }

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    public QuestionID getId() {
        return id;
    }

    public void setId(QuestionID id) {
        this.id = id;
    }
}



