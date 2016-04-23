package com.mocha.server.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private String id;
    private String username;
    private String password;
    private String lastLoginDate;
    private String lastSubmissionDate;
    private int coffeeBeans;
    private List<Submission> submissions;
    private Map<Integer, Integer> topicMasteryLevels;

    public User(String id, String username, String password, String lastLoginDate, String lastSubmissionDate, int coffeeBeans, List<Submission> submissions, Map<Integer, Integer> topicMasteryLevels) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.lastSubmissionDate = lastSubmissionDate;
        this.coffeeBeans = coffeeBeans;
        this.submissions = submissions;
        this.topicMasteryLevels = topicMasteryLevels;
    }

    public User(){
        submissions = new ArrayList<>();
        coffeeBeans = 0;
    }
    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public String getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    public void setLastSubmissionDate(String lastSubmissionDate) {
        this.lastSubmissionDate = lastSubmissionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public Map<Integer, Integer> getTopicMasteryLevels() {
        return topicMasteryLevels;
    }

    public void setTopicMasteryLevels(Map<Integer, Integer> topicMasteryLevels) {
        this.topicMasteryLevels = topicMasteryLevels;
    }
}
