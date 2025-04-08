package com.bridgelabz.modifyrecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalaryModification {
    public static void main(String[] args) throws FileNotFoundException{
        String inputfilePath = "src/main/java/com/bridgelabz/modifyrecord/EmployeeDetails.csv";
        String outputfilePath = "src/main/java/com/bridgelabz/modifyrecord/ModifiedEmployeeDetails.csv";

        List<String[]> updatedSalary = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(inputfilePath))){
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine())!= null){
                if(isHeader){
                    isHeader = false;
                    updatedSalary.add(line.split(","));
                    continue;
                }
                else{
                    String[] columns = line.split(",");
                    String department = columns[2];
                    double salary = Double.parseDouble(columns[3]);
                    if(department.equals("IT")){
                        salary*=1.10;
                        columns[3] = String.format("%.2f", salary);
                    }
                    updatedSalary.add(columns);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputfilePath))){
            for(String[] record : updatedSalary){
                writer.write(String.join(",", record));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
