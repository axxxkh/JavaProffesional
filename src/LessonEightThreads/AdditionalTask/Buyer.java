package LessonEightThreads.AdditionalTask;

public class Buyer extends Thread {
    private Store store;
    private String name;

    public Buyer(Store store, String name) {
        this.store = store;
        this.name = name;
    }

    @Override
    public synchronized void run() {
        Product[] products = store.getProducts();
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (products[i].getProduct()) {
                    System.out.println(name + " buy product in bucket " + i);
                }
            }
        }
    }
}
