package com.mycompany.internshipproject;


import org.json.CDL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class CsvFileToJsonFile {

    public static void main(String[] args) throws FileNotFoundException {
        String f = "C:\\Users\\User\\Documents\\NetBeansProjects\\Project\\InternShipProject\\economic-survey.csv";
        File file = new File(f);
 
        InputStream inputStream = new FileInputStream(file);
        //System.out.println(inputStream==null);
        String csvAsString = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
        String json = CDL.toJSONArray(csvAsString).toString();
        try {
            Files.write(Path.of("output.json"), json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
