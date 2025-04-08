package com.bridgelabz.writefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/writefile/EmployeeDetails.csv";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("104,Chirag,Finance,62000\n");
            writer.write("105,Manan,HR,58000\n");
            writer.write("106,Aman,Marketing,33000\n");
            writer.write("107,Ayush,Accounts,40000\n");
            writer.write("105,Manan,HR,58000\n");

            System.out.println("CSV File Written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
