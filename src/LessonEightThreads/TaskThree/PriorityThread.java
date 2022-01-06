package LessonEightThreads.TaskThree;

public class PriorityThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(110);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Priority Thread " + i);
        }
    }
}
