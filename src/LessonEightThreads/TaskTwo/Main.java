package LessonEightThreads.TaskTwo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable firstTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("first thread " + i);
                }
            }
        };
        Runnable secondTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("second thread " + i);
            }
        };
        Runnable thirdTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("third thread " + i);
            }
        };

        Thread firstThread = new Thread(firstTask, "first thread");
        Thread secondThread = new Thread(secondTask, "second thread");
        Thread thirdThread = new Thread(thirdTask, "third thread");

        firstThread.start();
        secondThread.start();
        secondThread.join();
        thirdThread.start();
    }
}
