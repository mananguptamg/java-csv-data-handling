package com.bridgelabz.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergingCSV {
    public static void main(String[] args) {
        String filePath1 = "src/main/java/com/bridgelabz/mergecsv/students1.csv";
        String filePath2 = "src/main/java/com/bridgelabz/mergecsv/students2.csv";
        String filePath3 = "src/main/java/com/bridgelabz/mergecsv/mergedFile.csv";

        Map<String, Student> studentMap = new HashMap<>();
        try {
            CSVReader reader1 = new CSVReader(new FileReader(filePath1));

            String[] line1;
            boolean isHeader = true;
            while((line1 = reader1.readNext())!=null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String id = line1[0];
                String name = line1[1];
                String age = line1[2];

                Student student = new Student();
                student.name = name;
                student.age = age;

                studentMap.put(id,student);
            }
            CSVReader reader2 = new CSVReader(new FileReader(filePath2));

            String[] line2;
            boolean isHeader2 = true;
            while((line2 = reader2.readNext())!=null){
                if(isHeader2){
                    isHeader2 = false;
                    continue;
                }
                String id = line2[0];
                String marks = line2[1];
                String grade = line2[2];

                if(studentMap.containsKey(id)){
                    Student student = studentMap.get(id);
                    student.marks = marks;
                    student.grade = grade;
                }
            }
            CSVWriter writer = new CSVWriter(new FileWriter(filePath3));
            writer.writeNext(new String[]{"ID","Name","Age","Marks","Grade"});

            for(Map.Entry<String, Student> entry : studentMap.entrySet()){
                String id = entry.getKey();
                Student s = entry.getValue();
                writer.writeNext(new String[]{id,s.name,s.age,s.marks,s.grade});
            }
            System.out.println("Csv file merged");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
