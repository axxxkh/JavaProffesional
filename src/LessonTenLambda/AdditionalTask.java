package LessonTenLambda;

import java.util.Arrays;
import java.util.Random;
import java.util.function.BiFunction;

public class AdditionalTask {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> minus = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> div = (a, b) -> a / b;
        BiFunction<Integer, Integer, Integer> mul = (a, b) -> a * b;

        Random rand = new Random();

        int[] array = Arrays.stream(new int[10])
                .map(x -> rand.nextInt(100))
                .toArray();

        System.out.println(add.apply(array[0], array[1]));
        System.out.println(minus.apply(array[0], array[1]));
        System.out.println(div.apply(array[0], array[1]));
        System.out.println(mul.apply(array[0], array[1]));
        System.out.println(Arrays.toString(array));
    }
}
