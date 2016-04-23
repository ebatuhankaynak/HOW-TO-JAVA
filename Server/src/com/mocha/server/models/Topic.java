package com.mocha.server.models;

import com.mocha.server.models.Questions.Question;

import java.util.List;
import java.util.Map;

public class Topic {
    private String id;
    private String name;
    private Map<Integer, Integer> topicLevelRequirements;
    private List<Question> questions;
}
