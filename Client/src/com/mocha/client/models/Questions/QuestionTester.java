package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * Question Tester
 * Tests the question classes written
 * v 1.0
 */
public class QuestionTester
{
    public static void main( String args[])
    {
        String[] testCases = new String[ 5];
        for( int i = 0; i < testCases.length; i++)
        {
            testCases[i] = String.valueOf( i);
        }
        QuestionID id = new QuestionID( 1, 1, 0);
        TestCaseQuestion Q1 = new TestCaseQuestion( "Please enter test cases for this code",id, 250, testCases, testCases, "System.out.println( Hello)");

    }
}
