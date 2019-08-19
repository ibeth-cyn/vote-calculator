package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {

    String file;
    ArrayList<String> list;

    public FileRead() {

    }

    public ArrayList<String> fileRead(String fileName) {
        this.file = fileName;

        //References one line at a time
        String line = null;
        list = new ArrayList<String>();
        //Wrapping the file in a try-catch method to cater for exceptions
        try {
            //Read the file
            FileReader fileReader = new FileReader(file);

            //Wrap the file in a buffered reader for efficiency
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file ' " + file + "'");
        } catch (IOException e) {
            System.out.println("Error reading file ' " + file + " ' ");
        }

        return list;
    }
}