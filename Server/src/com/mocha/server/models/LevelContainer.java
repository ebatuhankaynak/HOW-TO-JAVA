package com.mocha.server.models;

/**
 * Created by Hüseyin Ziya İmamoğlu on 29.04.2016.
 */

public class LevelContainer
{
    // Instance Variables
    private int score;
    private int level;

    // Constructor
    public LevelContainer( int score, int level)
    {
        this.score = score;
        this.level = level;
    }

    private LevelContainer()
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
}





