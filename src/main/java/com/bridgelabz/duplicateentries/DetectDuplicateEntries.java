package com.bridgelabz.duplicateentries;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DetectDuplicateEntries {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/duplicateentries/StudentMarks.csv";

        Map<String, StudentData> studentMap = new HashMap<>();
        try{
            CSVReader reader = new CSVReader(new FileReader(filePath));

            String[] line;
            boolean isHeader = true;
            while((line = reader.readNext())!=null){
                if(isHeader){
                    isHeader = false;
                    System.out.println("Duplicate entries are: ");
                    System.out.printf("%-5s %-7s %-5s %-5s%n", "ID","Name","Age","Marks");
                    continue;
                }
                String id = line[0];
                String name = line[1];
                String age = line[2];
                String marks = line[3];

                StudentData student = new StudentData();
                student.name = name;
                student.age = age;
                student.marks = marks;
                if(studentMap.containsKey(id)){
                    System.out.printf("%-5s %-7s %-5s %-5s%n", line[0], line[1], line[2], line[3]);
                }
                else{
                    studentMap.put(id, student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
