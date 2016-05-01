package com.mocha.client.models.Questions;

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
    private String[] testCaseAnswers;
    private String testClass;
    private String question;
    private int coffeeBeansAwarded;
    private QuestionID id;
    private String type;

    // Constructor
    public CompiledQuestion(String question, QuestionID id, int coffeeBeansAwarded,
                            String[] testCases, String[] testCaseAnswers, String testClass, String type)
    {
        this.testCases = testCases;
        this.testCaseAnswers = testCaseAnswers;
        this.testClass = testClass;
        this.question = question;
        this.coffeeBeansAwarded = coffeeBeansAwarded;
        this.id = id;
        this.type = type;
    }

    public CompiledQuestion(){

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

    public String[] getTestCaseAnswers() {
        return testCaseAnswers;
    }

    public int getCoffeeBeansAwarded() {
        return coffeeBeansAwarded;
    }

    public void setCoffeeBeansAwarded(int coffeeBeansAwarded) {
        this.coffeeBeansAwarded = coffeeBeansAwarded;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuestionID getId() {
        return id;
    }

    public void setId(QuestionID id) {
        this.id = id;
    }

    public int getCoffeeBeansawarded() {
        return coffeeBeansAwarded;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



