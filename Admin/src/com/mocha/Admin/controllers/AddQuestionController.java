package com.mocha.Admin.controllers;

/**
 * Created by E.Batuhan Kaynak on 30.4.2016.
 */
public class AddQuestionController extends Controller {

    /*
    private QuestionRepository questionContainers;

    public AdminPanelController(){
        questionContainers = new QuestionRepository( jongo.getCollection("QuestionContainers"));

    }*/

    /*
    public void addQuestion(){
        QuestionContainer container = new QuestionContainer( "DATA_TYPES", "1");
        QuestionID id = new QuestionID( 1, 1, "DATA_TYPES");
        String [] testCases  = new String [5];
        String[] testCaseAnswers = {"1", "1", "2", "6", "24"};

        for( int i = 0; i < testCases.length; i++)
        {
            testCases[i] = i + "";
        }

        String testClass = "public class Main{ public static void main( String[] args) { System.out.println( factorial( Integer.parseInt( args[0]))); } ";


        MethodQuestion q1 = new MethodQuestion( "Write a recursive method that computes the factorial", id , 100, testCases, testCaseAnswers, testClass);
        container.add( q1);
        container.add( q1);

        questionContainers.add( container);
    }*/
}
