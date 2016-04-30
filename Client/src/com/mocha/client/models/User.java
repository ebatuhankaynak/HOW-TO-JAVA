package com.mocha.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Hüseyin Ziya İmamoğlu
 * 28.04.2016
 * ${CLASS_NAME}
 * Info about class
 * v 1.0
 */

/* Score and coffeeBeans are different.
 * Score doesn't change, while coffeebeans decreases with buying things from shop
 * They start as the same thing.
 */

public class User
{
    @JsonProperty
    private String id;
    private String username;
    private String password;
    private String lastLoginDate;
    private String lastSubmissionDate;
    private UserProgress progress;
    private ArrayList<String> themes;
    private String currentTheme;

    public User(String id, String username, String password, String lastLoginDate, String lastSubmissionDate,
                int coffeeBeans, List<com.mocha.server.models.Submission> submissions, String currentTheme)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.lastSubmissionDate = lastSubmissionDate;
        progress = new UserProgress( coffeeBeans);
        themes = new ArrayList<>();
        this.currentTheme = currentTheme;
    }


    public User(){
        progress  = new UserProgress( 0);
        themes = new ArrayList<>();
        themes.add("Null");
        currentTheme = "Null";
    }


    public String getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    public void setLastSubmissionDate( String lastSubmissionDate) {
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

    public void setProgress(UserProgress progress)
    {
        this.progress = progress;
    }

    public UserProgress getProgress()
    {
        return progress;
    }

    public ArrayList<String> getThemes()
    {
        return themes;
    }

    public void setThemes( ArrayList<String> themes)   {
        this.themes = themes;
    }

    public void addTheme( String theme)
    {
        themes.add( theme);
    }

    public String getCurrentTheme()
    {
        return currentTheme;
    }

    public void setCurrentTheme(String currentTheme)
    {
        this.currentTheme = currentTheme;
    }

    public int getLevel( String topic)
    {
        return progress.getLevel( topic);
    }

    public int getScore( String topic)
    {
        return progress.getScore( topic);
    }

    public int getTotalScore()
    {
        return progress.getTotalScore();
    }

    public int getTotalCoffeeBeans()
    {
        return progress.getTotalCoffeeBeans();
    }

    public void update( String topic, int scoreGained)
    {
        progress.update( topic, scoreGained);
    }




}
