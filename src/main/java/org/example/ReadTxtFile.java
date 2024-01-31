package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTxtFile {
    public List<String> getCourses(){
        List<String> courses = new ArrayList<>();
        try {
            System.out.println("Started to read file");
            File myObj = new File("C:\\Users\\kabdullayev\\Desktop\\courses.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                courses.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return courses;
    }
}
