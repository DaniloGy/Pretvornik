import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    private String fileName;
    private String data;

    public CreateFile(String fileName, String data) {
        this.fileName = fileName.substring(0, fileName.length()-4) + "html";
        this.data = data;
    }

    public void createHtmlFile(){
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                writeToFile();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
