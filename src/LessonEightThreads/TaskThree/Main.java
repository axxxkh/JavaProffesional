package LessonEightThreads.TaskThree;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new PriorityThread());
        Thread secondThread = new Thread(new PriorityRunner());
        Thread thirdThread = new Thread(new PriorityRunner());

        firstThread.setPriority(1);
        firstThread.setDaemon(true);
        secondThread.setPriority(10);
        thirdThread.setPriority(5);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
    }
}
