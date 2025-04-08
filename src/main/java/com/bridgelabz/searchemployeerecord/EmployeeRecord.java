package com.bridgelabz.searchemployeerecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeRecord {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/main/java/com/bridgelabz/searchemployeerecord/EmployeeDetails.csv";
        System.out.print("Enter employee name to be searched: ");
        String employeeName = scanner.nextLine();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;

            System.out.printf("%-8s %-7s%n","Department","Salary");
            System.out.println("--------------------------");
            boolean isRecordFound = false;
            while((line = reader.readLine())!= null){
                String[] columns = line.split(",");
                String name = columns[1];
                String department = columns[2];
                int salary = Integer.parseInt(columns[3]);
                if(name.equals(employeeName)){
                    System.out.printf("%-8s %-7s%n", columns[2], columns[3]);
                    isRecordFound = true;
                }
            }
            if(!isRecordFound){
                System.out.println("Record not found");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
