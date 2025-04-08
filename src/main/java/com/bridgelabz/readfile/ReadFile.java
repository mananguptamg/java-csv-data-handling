package com.bridgelabz.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/readfile/StudentMarks.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                System.out.printf("%-5s %-7s %-5s %-5s%n", columns[0], columns[1], columns[2], columns[3]);
                System.out.println("--------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
