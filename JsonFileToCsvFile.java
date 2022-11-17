
package com.mycompany.internshipproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONArray;
import org.json.JSONTokener;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.json.CDL;

public class JsonFileToCsvFile {
    public static void main(String[] args) throws FileNotFoundException {
        String f = "C:\\Users\\User\\Documents\\NetBeansProjects\\Project\\InternShipProject\\input.json";
        File file = new File(f);
 
        InputStream inputStream = new FileInputStream(file);
        JSONArray jsonArray = new JSONArray(new JSONTokener(inputStream));
        try {
            Files.write(Path.of("csvoutput.csv"), CDL.toString(jsonArray).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
