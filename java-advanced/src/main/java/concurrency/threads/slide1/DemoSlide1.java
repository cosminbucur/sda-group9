package concurrency.threads.slide1;

public class DemoSlide1 {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        try {
            Thread.sleep(300);
//            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            System.out.println(threadName + " thread interrupted");
        }
    }
}
