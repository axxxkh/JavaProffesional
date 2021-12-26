package LessonEightThreads.TaskThree;

public class PriorityRunner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Priority runner " + i);
        }
    }
}
