package com.mocha.server.repository;

import com.mocha.server.models.Questions.ClassQuestion;
import com.mocha.server.models.Questions.MethodQuestion;
import com.mocha.server.models.Questions.QuestionContainer;
import com.mocha.server.models.Questions.QuestionID;
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
    private AdminRepository admins;

    public Repository(String connectionString, String dbName){
        // To connect to mongodb server
        MongoClientURI mongoClientURI = new MongoClientURI(connectionString);

        DB db = new MongoClient(mongoClientURI).getDB(dbName);

        Jongo jongo = new Jongo(db);
        users = new UsersRepository(jongo.getCollection("Users"));
        questionContainers = new QuestionRepository( jongo.getCollection("QuestionContainers"));
        admins = new AdminRepository(jongo.getCollection("Admins"));
        //--------------------------------------------------------------------------------------------------// Test
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
        //container.add( q1);

        questionContainers.add( container);
        //-------------------------------------------------------------------------------------
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

    public AdminRepository getAdmins() {
        return admins;
    }

    public void setAdmins(AdminRepository admins) {
        this.admins = admins;
    }
}
