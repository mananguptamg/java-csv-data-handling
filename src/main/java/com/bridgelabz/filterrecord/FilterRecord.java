package com.bridgelabz.filterrecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecord {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src/main/java/com/bridgelabz/filterrecord/StudentMarks.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;

            System.out.println("Students who scored more than 80");
            System.out.printf("%-5s %-7s %-5s %-5s%n", "ID","Name","Age","Marks");
            System.out.println("--------------------------");
            while((line = reader.readLine())!= null){
                String[] columns = line.split(",");
                if(Double.parseDouble(columns[3]) >80.0){
                    System.out.printf("%-5s %-7s %-5s %-5s%n", columns[0], columns[1], columns[2], columns[3]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

