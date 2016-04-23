package com.mocha.server.CompilerCapsule;

import java.io.*;
import java.util.*;

public class CompilerCapsule {

    // TODO check if output is equals expected output
    private TestCaseStorage testCaseStorage;

    private String output;

    public CompilerCapsule(){
        testCaseStorage = new TestCaseStorage();
    }

    public void addTestCase(String input, String expectedOutput){
        testCaseStorage.add(input, expectedOutput);
    }

    public void compile(String code)  {

        String uniqueId = String.valueOf((int)(Math.random() * Math.pow(10, 9))) + "" + (System.currentTimeMillis() / 1000L);

        System.out.println( uniqueId);
        File file = new File("CompilerStorage\\" + uniqueId + "\\Main.java");
        file.getParentFile().mkdirs();
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileWriter.write(code);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            process = runtime.exec("cmd /c \"cd CompilerStorage\\" + uniqueId + " && C:\\jdk1.8.0_60\\bin\\javac.exe Main.java && java Main\"");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        List<String> allList = new ArrayList<>();
        try {
            while((line = reader.readLine()) != null){
                allList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String all = String.join("\n", allList);
        System.out.println(all);

    }




}
