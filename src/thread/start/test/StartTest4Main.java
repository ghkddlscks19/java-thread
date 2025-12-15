package thread.start.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("A", 1000), "Thread-A");
        Thread thread2 = new Thread(new MyRunnable("B", 500), "Thread-B");
        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable {
        String alphabet;
        int sleep;

        public MyRunnable(String alphabet, int sleep) {
            this.alphabet = alphabet;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            while (true) {
                log(alphabet);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
