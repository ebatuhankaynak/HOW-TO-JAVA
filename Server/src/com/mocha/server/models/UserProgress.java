package com.mocha.server.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


public class UserProgress {
    // Constants
    private final static int LEVEL_CONSTANT = 1000;

    // Instance Variables
    @JsonProperty
    private int totalCoffeeBeans;
    private int totalScore;
    private Map<String, Integer> topicsToInt;
    private ArrayList<LevelContainer> scores;

    // Constructor
    public UserProgress(int totalCoffeeBeans) {
        this.totalCoffeeBeans = totalCoffeeBeans;
        scores = new ArrayList<>();
        topicsToInt = new HashMap<>();
        addTopic("RECURSION");
        addTopic("METHODS");
        addTopic("CLASS");
    }

    private UserProgress() {
    }

    // Getter and setter methods

    public int getTotalCoffeeBeans() {
        return totalCoffeeBeans;
    }

    public void setTotalCoffeeBeans(int totalCoffeeBeans) {
        this.totalCoffeeBeans = totalCoffeeBeans;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void addTopic(String topic) {
        scores.add(new LevelContainer(0, 0));
        topicsToInt.put(topic, scores.size() - 1);
    }

    public int getScore(String topic) {
        return scores.get(topicsToInt.get(topic)).getScore();
    }

    public int getLevel(String topic) {
        return scores.get(topicsToInt.get(topic)).getLevel();
    }

    public ArrayList<LevelContainer> getScores() {
        return scores;
    }

    public Map<String, Integer> getTopicsToInt() {
        return topicsToInt;
    }

    public static int getLevelConstant() {
        return LEVEL_CONSTANT;
    }

    public void setScores(ArrayList<LevelContainer> scores) {
        this.scores = scores;
    }

    public void setTopicsToInt(Map<String, Integer> topicsToInt) {
        this.topicsToInt = topicsToInt;
    }

    /*

    public int getTotalScore()
    {
        int result;

        result = 0;
        for( int i = 0; i < scores.size(); i++)
        {
            result = result + scores.get(i).getScore();
        }
        return result;
    } */

    public void update(String topic, int scoreGained) {
        int temp;
        int level;
        int score;

        temp = topicsToInt.get(topic);

        score = scores.get(temp).getScore();
        level = scores.get(temp).getLevel();

        if ((score + scoreGained) / LEVEL_CONSTANT > level) {
            level++;
        }

        scores.set(temp, new LevelContainer(score, level));
        totalScore = totalScore + scoreGained;
        totalCoffeeBeans = totalCoffeeBeans + scoreGained;
    }
}

