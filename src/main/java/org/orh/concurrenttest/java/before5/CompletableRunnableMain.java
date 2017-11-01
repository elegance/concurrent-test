package org.orh.concurrenttest.java.before5;

public class CompletableRunnableMain {
    public static void main(String[] args) throws InterruptedException {
        CompleteRunnable runnable = new CompleteRunnable();

        Thread thread = new Thread(runnable, "Sub");
        thread.start();

        System.out.printf("Thread: %s \n", Thread.currentThread().getName());
        // 串行
        thread.join();
        System.out.printf("runnable is completed:%s\n", runnable.isCompleted());

    }

    private static class CompleteRunnable implements Runnable {
        private volatile boolean completed = false;

        @Override
        public void run() {
            System.out.printf("Thread: %s Hello world...\n", Thread.currentThread().getName());

            completed = true;
        }

        boolean isCompleted() {
            return completed;
        }
    }
}
