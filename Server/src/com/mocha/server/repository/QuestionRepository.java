package com.mocha.server.repository;

import com.mocha.server.models.Questions.CompiledQuestionContainer;
import com.mocha.server.models.requests.QuestionRequest;
import org.jongo.MongoCollection;

/**
 * Hüseyin Ziya İmamoğlu
 * 19.04.2016
 * ${CLASS_NAME}
 * Info about class
 * v 1.0
 */
public class QuestionRepository
{
    private MongoCollection questionContainers;
    public QuestionRepository(MongoCollection questionContainers) {
        this.questionContainers = questionContainers;
    }

    public CompiledQuestionContainer find(QuestionRequest questionRequest){
        System.out.println("this is where bomb happens");
        CompiledQuestionContainer questions = questionContainers.findOne( questionRequest.toSearchQuery()).as( CompiledQuestionContainer.class);
        return  questions;
    }

    public void add( CompiledQuestionContainer container)
    {
        questionContainers.save(container);
    }
}

