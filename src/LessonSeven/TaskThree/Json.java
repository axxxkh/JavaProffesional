package LessonSeven.TaskThree;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {
    public static void main(String[] args) throws IOException {
        Adress adress = new Adress("Small", "Jashkiv", "street one", "123");
        Gson gson = new Gson();
        File file = new File("src/main/java/LessonSeven/TaskThree/adress.json");
        String json = gson.toJson(adress);
        System.out.println(json);
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.close();

        FileReader reader = new FileReader(file);
        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = reader.read()) != -1) {
            sb.append((char) i);
        }
        Adress adressFromJson = gson.fromJson(sb.toString(), Adress.class);
        System.out.println(adressFromJson);
    }
}
