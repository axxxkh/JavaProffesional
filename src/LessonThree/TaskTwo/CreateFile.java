package LessonThree.TaskTwo;

import java.io.*;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        File myFile = new File("src/LessonThree/TaskTwo", "my.txt");
        myFile.createNewFile();
        FileWriter fileWriter = new FileWriter(myFile);
        fileWriter.write("asd" + 1000 + "  \n");
        fileWriter.write("asd" + 1000 + "  \n");
        fileWriter.write("asd" + 1000 + "  \n");
        fileWriter.write("asd" + 1000 + "  \n");
        fileWriter.close();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
