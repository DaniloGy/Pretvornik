package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    private String filePath;
    private String data;
    private String fileName;

    public ReadFile(String filePath) {
        this.filePath = filePath;
        readFromFile();
    }

    public void readFromFile(){
        try {
            File myObj = new File(filePath);
            fileName = myObj.getName();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getData() {
        return data;
    }

    public String getFileName() {
        return fileName;
    }
}
