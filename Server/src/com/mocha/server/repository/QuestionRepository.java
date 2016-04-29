package com.mocha.server.repository;

import com.mocha.server.models.Questions.QuestionContainer;
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

    public QuestionContainer find(QuestionRequest questionRequest){
        System.out.println("this is where bomb happens");
        QuestionContainer questions = questionContainers.findOne( questionRequest.toSearchQuery()).as( QuestionContainer.class);
        return  questions;
    }

    public void add( QuestionContainer container)
    {
        questionContainers.save(container);
    }
}

