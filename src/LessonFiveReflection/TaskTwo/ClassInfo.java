package LessonFiveReflection.TaskTwo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInfo {
    public static void main(String[] args) {
        try {
            Class cl = String.class;
            System.out.println(cl);
            Field[] fields = cl.getFields();
            Arrays.stream(fields).forEach(System.out::println);
            Method[] methods = cl.getMethods();
            Arrays.stream(methods).forEach(System.out::println);
            // пройшла оптимізація
            Arrays.stream(cl.getConstructors()).forEach(System.out::println);
            Arrays.stream(cl.getAnnotations()).forEach(System.out::println);
            Arrays.stream(cl.getDeclaredFields()).forEach(System.out::println);
            Arrays.stream(cl.getDeclaredMethods()).forEach(System.out::println);
            int modifier = cl.getModifiers();
            System.out.println(Modifier.isFinal(modifier));
        } catch (Exception e) {
            System.out.println("some error");
        }
    }
}
