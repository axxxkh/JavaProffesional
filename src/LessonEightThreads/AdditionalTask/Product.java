package LessonEightThreads.AdditionalTask;

public class Product {
    private int quantity;

    public Product(int quantity) {
        this.quantity = quantity;
    }

    synchronized boolean getProduct() {
        if (quantity > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            quantity--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "quantity=" + quantity +
                '}';
    }
}
