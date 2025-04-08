package com.bridgelabz.csvtoobject;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVConversion {
    public static void main(String[] args) throws FileNotFoundException{
        String filePath = "src/main/java/com/bridgelabz/csvtoobject/ContactList.csv";
        List<Person> personList = new ArrayList<>();
        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            String[] line;
            boolean isHeader = true;
            while ((line = reader.readNext())!= null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String name = line[0];
                String email = line[1];
                String phoneNumber = line[2];

                Person person = new Person(name,email,phoneNumber);
                personList.add(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
