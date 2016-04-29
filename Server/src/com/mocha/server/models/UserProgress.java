package com.mocha.server.models;

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
 * Score doesn't change, while coffeebeans decreases with buyinn things from shop
 * They start as the same thing.
 */


public class UserProgress
{
    // Constants
    private final static int LEVEL_CONSTANT = 1000;

    // Instance Variables
    private int totalCoffeeBeans;
    private int totalScore;
    private Map<String, Integer> topicsToInt;
    private ArrayList<levelContainer> scores;

    private int index;

    // Constructor
    public UserProgress( int totalCoffeeBeans)
    {
        this.totalCoffeeBeans = totalCoffeeBeans;
        scores = new ArrayList<>();
        index = 0;
        topicsToInt = new HashMap<>();
        addTopic("DATA_TYPES");
    }

    private UserProgress()
    {
    }

    // Getter and setter methods


    public int getTotalCoffeeBeans()
    {
        return totalCoffeeBeans;
    }

    public void setTotalCoffeeBeans( int totalCoffeeBeans)
    {
        this.totalCoffeeBeans = totalCoffeeBeans;
    }

    public int getTotalScore() { return totalScore; }

    public void setTotalScore(int totalScore)
    {
        this.totalScore = totalScore;
    }

    public void addTopic(String topic)
    {
        scores.add( new levelContainer(0,0,0));
        topicsToInt.put(topic, index++);
    }

    public int getScore( String topic)
    {
       return scores.get( topicsToInt.get( topic)).getScore();
    }

    public int getLevel( String topic)
    {
        return  scores.get( topicsToInt.get( topic)).getLevel();
    }

    public int getCoffeeBeans( String topic)
    {
        return scores.get( topicsToInt.get( topic)).getCoffeeBeans();
    }

    public ArrayList<levelContainer> getScores() {
        return scores;
    }

    public Map<String, Integer> getTopicsToInt() {
        return topicsToInt;
    }

    public int getIndex() {
        return index;
    }

    public static int getLevelConstant() {
        return LEVEL_CONSTANT;
    }

    public void setScores(ArrayList<levelContainer> scores) {
        this.scores = scores;
    }

    public void setTopicsToInt(Map<String, Integer> topicsToInt) {
        this.topicsToInt = topicsToInt;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public void update( String topic, int scoreGained, boolean[] isPassed)
    {
        boolean cond;

        cond = true;
        for (int i = 0; i < isPassed.length && cond; i++)
        {
            cond = !isPassed[i];
        }

        if (!cond)
        {
            int temp;
            int level;
            int score;

            temp = topicsToInt.get( topic);

            score = scores.get( temp).getScore();
            level = scores.get( temp).getLevel();

            if( ( score + scoreGained) / LEVEL_CONSTANT > level)
            {
                level++;
            }

            scores.set( temp, new levelContainer( score, level, score));
            totalScore = totalScore + scoreGained;
        }
    }

    public void update( String topic, int scoreGained, boolean isPassed)
    {
        if ( isPassed)
        {
            int temp;
            int level;
            int score;

            temp = topicsToInt.get( topic);

            score = scores.get( temp).getScore();
            level = scores.get( temp).getLevel();

            if( ( score + scoreGained) / LEVEL_CONSTANT > level)
            {
                level++;
            }

            scores.set( temp, new levelContainer( score, level, score));
            totalScore = totalScore + scoreGained;
        }
    }

    // Create an inner class for level container

    private class levelContainer
    {
        // Instance Variables
        private int score;
        private int coffeeBeans;
        private int level;

        // Constructor
        public levelContainer( int score, int level, int coffeeBeans)
        {
            this.score = score;
            this.level = level;
            this.coffeeBeans = coffeeBeans;
        }

        private levelContainer()
        {
        }

        // getter and setter methods

        public int getScore()
        {
            return score;
        }

        public int getLevel()
        {
            return level;
        }

        public void setScore(int score)
        {
            this.score = score;
        }

        public void setLevel(int level)
        {
            this.level = level;
        }

        public int getCoffeeBeans()
        {
            return coffeeBeans;
        }

        public void setCoffeeBeans(int coffeeBeans)
        {
            this.coffeeBeans = coffeeBeans;
        }

    }
}


