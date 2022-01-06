package LessonEightThreads.AdditionalTask;

import java.util.Arrays;

public class Store {
    private Product[] products;

    public Product[] getProducts() {
        return products;
    }

    public void createStore() {
        products = new Product[10];
        for (int i = 0; i < 10; i++) {
            products[i] = new Product((int) (Math.random() * 100));
        }
        Arrays.stream(products).forEach(System.out::println);
    }
}
