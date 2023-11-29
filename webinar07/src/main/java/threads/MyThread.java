package threads;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
//        myThread.start();
//        myThread.run();

//        Thread tread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("From Runnable: " + Thread.currentThread().getName());
//            }
//        });

        Thread tread = new Thread(() -> System.out.println("From Runnable: " + Thread.currentThread().getName()));



        myThread.start();
        tread.start();


        tread.join();
        myThread.join();

        System.out.println("MAIN: " + Thread.currentThread().getName());

    }
}
