package com.bucur.concurrency.threads.slide2;

public class DemoSlide2 {

    public static void main(String[] args) throws InterruptedException {
        StopWatchThread stopWatchThread1 = new com.bucur.concurrency.threads.slide2.StopWatchThread();
        com.bucur.concurrency.threads.slide2.StopWatchThread stopWatchThread2 = new com.bucur.concurrency.threads.slide2.StopWatchThread();
        stopWatchThread1.start();
        stopWatchThread2.start();

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starts");
        Thread.sleep(5000);
        System.out.println(threadName + " starts");
        Thread.sleep(5000);
        System.out.println(threadName + " starts");
    }
}
