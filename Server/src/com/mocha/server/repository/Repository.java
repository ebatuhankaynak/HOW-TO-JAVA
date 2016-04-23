package com.mocha.server.repository;

import com.mocha.server.models.Questions.*;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;

/**
 * Created by Ergün Batuhan Kaynak on 28.3.2016.
 */
public class Repository {

    private UsersRepository users;
    private QuestionRepository questionContainers;

    public Repository(String connectionString, String dbName){
        // To connect to mongodb server
        MongoClientURI mongoClientURI = new MongoClientURI(connectionString);

        DB db = new MongoClient(mongoClientURI).getDB(dbName);

        Jongo jongo = new Jongo(db);
        users = new UsersRepository(jongo.getCollection("Users"));

        questionContainers = new QuestionRepository( jongo.getCollection("QuestionContainers"));
    }

    public UsersRepository getUsers() {
        return users;
    }

    public QuestionRepository getQuestionContainers()
    {
        return questionContainers;
    }

    public void setUsers(UsersRepository users) {
        this.users = users;
    }

    public void setQuestionContainers(QuestionRepository questionContainers)
    {
        this.questionContainers = questionContainers;
    }
}
