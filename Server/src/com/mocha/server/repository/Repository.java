package com.mocha.server.repository;

import com.mocha.server.models.Questions.CompiledQuestion;
import com.mocha.server.models.Questions.CompiledQuestionContainer;
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
        String type = "Method";
        CompiledQuestionContainer container = new CompiledQuestionContainer( "RECURSION", "1");
        QuestionID id = new QuestionID( 1, 1, "RECURSION");
        String [] testCases  = new String [5];
        String[] testCaseAnswers = {"1", "1", "2", "6", "24"};
        for( int i = 0; i < testCases.length; i++)
        {
            testCases[i] = i + "";
        }

        String testClass = "public class Main{ public static void main( String[] args) { System.out.println( factorial( Integer.parseInt( args[0]))); } ";


        CompiledQuestion q1 = new CompiledQuestion( "Write a recursive method that computes the factorial with the signature factorial", id , 100, testCases, testCaseAnswers, testClass, type);
        container.add( q1);

        QuestionID id1 = new QuestionID( 1, 1, "RECURSION");
        String [] testCases1  = new String [5];
        String[] testCaseAnswers1 = {"0", "1", "3", "6", "10"};

        for( int i = 0; i < testCases1.length; i++)
        {
            testCases1[i] = i + "";
        }

        String testClass1 = "public class Main{ public static void main( String[] args) { System.out.println( sum( Integer.parseInt( args[0]))); } ";


        CompiledQuestion q2 = new CompiledQuestion( "Write a recursive method that computes the sum with the siganture sum", id1 , 100, testCases1, testCaseAnswers1, testClass1, type);
        container.add( q2);

        questionContainers.add( container);

        CompiledQuestionContainer container2 = new CompiledQuestionContainer("RANDOM", "-1");
        container2.add(q1);
        container2.add(q2);
        questionContainers.add(container2);

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
