package LessonThree.TaskThree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringDivider {
    public static void main(String[] args) throws IOException {
        StringBuilder myString = new StringBuilder("Здесь для определения ошибки, связанной с вычислением факториала, " +
                "определен класс FactorialException, который наследуется от Exception");
        System.out.println(myString.substring(0, myString.length() / 2));
        System.out.println(myString.substring(myString.length() / 2, myString.length()));
        File myFile = new File("src/LessonThree/TaskTwo", "my.txt");
        myFile.createNewFile();
        FileWriter writer = new FileWriter(myFile);
        writer.write(myString.substring(0, myString.length() / 2));
        writer.write("\n");
        writer.write(myString.substring(myString.length() / 2, myString.length()));
        writer.close();

    }
}
