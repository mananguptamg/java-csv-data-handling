package com.bridgelabz.csvdatavalidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/java/com/bridgelabz/csvdatavalidation/ContactList.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = reader.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    System.out.println("Entries with incorrect data are:");
                    System.out.printf("%-5s %-15s %-19s%n", "Name","Email","PhoneNumber");
                    System.out.println("-------------------------------");
                    continue;
                }
                String[] columns = line.split(",");
                String name = columns[0];
                String email = columns[1];
                String phoneNumber = columns[2];

                if(!isValidMail(email) || !isValidNumber(phoneNumber)){
                    System.out.printf("%-5s %-15s %-19s%n", columns[0], columns[1], columns[2]);
                }
            }
        }
    }
    public static boolean isValidMail(String email){
        String regex = "^[a-zA-Z0-9+-.]+@[a-zA-Z0-9]+\\.[A-Za-z]{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.find();
    }
    public static boolean isValidNumber(String phoneNumber){
        String regex = "[0-9]{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.find();
    }
}
