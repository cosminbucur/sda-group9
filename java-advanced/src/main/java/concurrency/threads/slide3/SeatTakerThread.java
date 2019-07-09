package concurrency.threads.slide3;

public class SeatTakerThread extends Thread {

    // manual instantiation
//    Bench bench = new Bench(2);

    Bench bench;

    // dependency injection
    public SeatTakerThread(Bench bench) {
        this.bench = bench;
    }

    @Override
    public void run() {
        bench.takeASeat();
    }
}
