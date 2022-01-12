package LessonTenLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TaskTwo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Supplier<Integer> rand = () -> (int) (Math.random() * 100);

        for (int i = 0; i < 10; i++) {
            list.add(rand.get());
        }

        System.out.println(list.stream()
                .map(x -> Math.pow(x, 2))
                .reduce((a, b) -> a + b).orElse(0.0));
    }
}
