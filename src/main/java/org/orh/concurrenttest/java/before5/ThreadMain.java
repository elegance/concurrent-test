package org.orh.concurrenttest.java.before5;

public class ThreadMain {
    public static void main(String[] args) {
        // 内置类
        Thread thread = new Thread(() -> System.out.println("Hello"), "Sub");

        thread.start();
    }
}
