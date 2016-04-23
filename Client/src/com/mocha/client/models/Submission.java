package com.mocha.client.models;

import com.mocha.server.CompilerCapsule.TestCaseResult;

import java.util.Map;

public class Submission {
    private String date;
    private String code;
    private Map<Integer, TestCaseResult> testCaseResults;

}
