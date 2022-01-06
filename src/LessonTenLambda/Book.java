package LessonTenLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Book {
    private String name;
    private String author;
    private int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        listBook.add(new Book("I", "A", 100));
        listBook.add(new Book("K", "B", 50));
        listBook.add(new Book("L", "C", 25));

        Function<Book, String> getInfo = b -> "Author is " + b.author + " book - " + b.name + " price - " + b.price;

        listBook.stream()
                .map(b -> getInfo.apply(b))
                .forEach(System.out::println);
    }
}
