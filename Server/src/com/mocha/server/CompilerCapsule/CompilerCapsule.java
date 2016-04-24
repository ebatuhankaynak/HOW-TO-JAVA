package com.mocha.server.CompilerCapsule;

import com.mocha.server.models.Questions.ClassQuestion;
import com.mocha.server.models.Questions.CompiledQuestion;

import java.io.*;
import java.util.*;

public class CompilerCapsule {

    // TODO check if output is equals expected output

    // Instance Variables
    private TestCaseStorage testCaseStorage;
    private String output;
    private boolean compiled;


    public CompilerCapsule(){
        testCaseStorage = new TestCaseStorage();
    }

    public void addTestCase(String input, String expectedOutput){
        testCaseStorage.add(input, expectedOutput);
    }

    public String [] compile(String code, CompiledQuestion question)  {

        compiled = false;
        String uniqueId = String.valueOf((int)(Math.random() * Math.pow(10, 9))) + "" + (System.currentTimeMillis() / 1000L);
        code = question.getTestClass() + code + "}" ;

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
            process = runtime.exec("cmd /c \"cd CompilerStorage\\" + uniqueId + " && C:\\jdk1.8.0_73\\bin\\javac.exe Main.java  2>results"+ uniqueId + ".txt");
        //    process = runtime.exec("cmd /c \"cd CompilerStorage\\" + uniqueId + " && C:\\jdk1.8.0_73\\bin\\javac.exe Main.java" );
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String fileName;

        fileName = "results"+ uniqueId + ".txt";

        try {
            output = readFile(fileName, uniqueId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output.length());

        if (output.length()== 0)
        {
         compiled = true;
        }
        String [] testCases = question.getTestCases();
        if (compiled)
        {
            for (int i = 0; i < testCases.length ; i++)
            {
                run(uniqueId, testCases[i]);
            }
        }
        try {
            output = readFile(fileName, uniqueId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output);
        int index = 0;
       // String[] outputArray = new String[output.length()];
        String temp;
        ArrayList <String> result = new ArrayList<>();

        temp = "";

       for( int i = 0; i < output.length(); i++) {
           if (output.charAt(i) != '/') {
               temp = temp + output.substring(i, i + 1);
           } else {
               result.add(temp);
               temp = "";
           }
       }
        System.out.println( result + "Resultant arrayList");

        String[] outputArray = new String[ result.size()];
        for( int i = 0; i < result.size(); i++) {
            outputArray[i] = result.get(i);
        }
        return  outputArray;

    }
    String readFile(String fileName, String uniqueId) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Hüseyin\\IdeaProjects\\Mocha\\CompilerStorage\\" + uniqueId + "\\results" + uniqueId+ ".txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("/");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();

        }

    }
    public void run(String uniqueId, String testCase)
    {

        System.out.print("run");
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            String str = "cmd /c \"cd CompilerStorage\\" + uniqueId + "\\" + " && java Main "+ testCase +" >> results"+ uniqueId +".txt";
            System.out.println(str);
            process = runtime.exec(str);
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isCompiled() {
        return compiled;
    }
}
/**
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

 BufferedReader ErrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
 String line = "";
 List<String> allList = new ArrayList<>();
 try {
 while((line = ErrReader.readLine()) != null){
 System.out.print(line);
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 String errAll = String.join("\n", allList);
 System.out.println(errAll) ;
 */