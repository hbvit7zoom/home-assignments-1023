package threads;

import java.util.ArrayList;
import java.util.List;

public class CounterMainWithObject {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        List<Thread> threads = new ArrayList<>();

        for (int k=0; k < 10000; k++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i = counter.getI();
                counter.setI(i + 1);
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("counter = " + counter.getI());
    }

}
