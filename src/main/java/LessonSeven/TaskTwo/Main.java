package LessonSeven.TaskTwo;

import LessonSeven.AdditionalTask.Animal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/LessonSeven/AdditionalTask/abc.xml");
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Animal animalFromFile = (Animal) ois.readObject();
            ois.close();
            System.out.println(animalFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
