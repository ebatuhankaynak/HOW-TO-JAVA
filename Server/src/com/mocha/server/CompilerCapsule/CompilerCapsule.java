package com.mocha.server.CompilerCapsule;

import java.io.*;
import java.util.*;

public class CompilerCapsule {

    // TODO check if output is equals expected output
    private TestCaseStorage testCaseStorage;
    private String output;
    private boolean compiled;

    public CompilerCapsule(){
        testCaseStorage = new TestCaseStorage();
    }

    public void addTestCase(String input, String expectedOutput){
        testCaseStorage.add(input, expectedOutput);
    }

    public String [] compile(String code)  {

        compiled = false;
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
        if (compiled)
        {
            run(uniqueId);
        }



        try {
            output = readFile(fileName, uniqueId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output);
        int index = 0;
        String[] outputArray = new String[output.length()];
        for (int i = 0; i < output.length();i++)
        {
                if (output.charAt(i) != '/')
                {
                    outputArray[index ] = String.valueOf(output.charAt(i ));
                    index++;
                }
        }
        return outputArray;
    }
    String readFile(String fileName, String uniqueId) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Hüseyin\\IdeaProjects\\Mocha\\CompilerStorage\\" + uniqueId + "\\results" + uniqueId+ ".txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();

        }

    }
    public void run(String uniqueId)
    {
        System.out.print("run");
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            String str = "cmd /c \"cd CompilerStorage\\" + uniqueId + "\\" + " && java Main> results"+ uniqueId +".txt";
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