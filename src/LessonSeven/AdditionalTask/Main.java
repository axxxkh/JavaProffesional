package LessonSeven.AdditionalTask;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/LessonSeven/AdditionalTask/abc.xml");
        Animal mammut = new Animal("Kitty", 15, 10);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(mammut);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
