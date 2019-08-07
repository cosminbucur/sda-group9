package com.bucur.concurrency.threads.slide3;

public class Bench {

    private int availableSeats;

    public Bench(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void takeASeat() {
        System.out.println(Thread.currentThread().getName());
        if (availableSeats > 0) {
            System.out.println("take a seat from " + availableSeats);
            availableSeats--;
            System.out.println("free seats: " + availableSeats);
        } else {
            System.out.println("no more seats");
        }
    }
}
