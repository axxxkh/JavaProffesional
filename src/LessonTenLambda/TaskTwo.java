package LessonTenLambda;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        list.stream().forEach(System.out::println);
        System.out.println(list.stream().map(x -> Math.pow(x, 2)).reduce((a, b) -> a + b));
    }
}
