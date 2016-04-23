package com.mocha.server.CompilerCapsule;

import com.mocha.server.models.TestCase;

import java.util.ArrayList;
import java.util.List;

public class TestCaseStorage {
    // TODO not map what is it define yor map
    List<TestCase> inputs;

    public TestCaseStorage(){
        inputs = new ArrayList<>();
    }

    public void add(String input, String expectedOutput){
        inputs.add(new TestCase(input, expectedOutput));
    }

}
