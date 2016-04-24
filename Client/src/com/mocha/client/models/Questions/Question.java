package com.mocha.client.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * Abstract Question Class
 * Creates a question
 * v 1.0
 */
public class Question
{
    // Instance Variables
    private QuestionID id;
    private String question; //Denotes the text of the question
    private int coffeeBeansAwarded; // Denotes the coffeee beans awarded for the question

    // Constructor
    private Question(){

    }

    public Question(String question, QuestionID id, int coffeeBeansAwarded)
    {
        this.question = question;
        this.id = id;
        this.coffeeBeansAwarded = coffeeBeansAwarded;
    }

    // Check method which will be implemented by the children of this class
    //public abstract boolean [] check( <T>);

    // Getter and setter methods
    public QuestionID getId()
    {
        return id;
    }

    public void setId(QuestionID id)
    {
        this.id = id;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return question;
    }

    public int getCoffeeBeansawarded()
    {
        return coffeeBeansAwarded;
    }

    public void setCoffeeBeansawarded(int coffeeBeansawarded)
    {
        this.coffeeBeansAwarded = coffeeBeansawarded;
    }
}

