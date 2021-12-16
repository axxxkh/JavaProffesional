package LessonFiveReflection.AdditionalTask;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class Cat {
    public static void main(String[] args) {

        try {
            Class cl = Animal.class;
            Animal cat = new Animal();

            Field field = cl.getDeclaredField("name");
            field.setAccessible(true);
            field.set(cat, "Kitty");
            field = cl.getDeclaredField("sex");
            field.setAccessible(true);
            field.set(cat, "female");
            field = cl.getDeclaredField("birthTime");
            field.setAccessible(true);
            field.set(cat, LocalDateTime.now().minusYears(10));
            System.out.println(cat);

        } catch (Exception e) {
            System.out.println("sdfs");
        }
    }
}
