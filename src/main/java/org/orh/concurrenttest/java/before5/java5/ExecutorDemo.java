package org.orh.concurrenttest.java.before5.java5;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(1);
    }
}
