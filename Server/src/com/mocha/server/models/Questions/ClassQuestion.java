package com.mocha.server.models.Questions;

/**
 * Hüseyin Ziya İmamoğlu
 * 17.04.2016
 * ${CLASS_NAME}
 * Info about class
 * v 1.0
 */
public class ClassQuestion extends CompiledQuestion {

    // Constructor
    public ClassQuestion(String question, QuestionID id, int coffeeBeansAwarded, String[] testCases,
                         String[] testCaseAnswers, String testClass) {
        super(question, id, coffeeBeansAwarded, testCases, testCaseAnswers, testClass);
    }
}




