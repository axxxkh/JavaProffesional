package LessonEightThreads.AdditionalTask;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.createStore();

        Buyer jack = new Buyer(store, "Jack");
        Buyer john = new Buyer(store, "John");
        Buyer jeremy = new Buyer(store, "Jeremy");

        jack.start();
        john.start();
        jeremy.start();
    }
}
