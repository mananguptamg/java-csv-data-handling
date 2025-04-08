package com.bridgelabz.countrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CoutingRows {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/bridgelabz/countrows/StudentMarks.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine())!= null){
                count++;
            }
            System.out.println("CSV File contains "+(count-1)+ " rows");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
