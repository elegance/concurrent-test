package org.orh.concurrenttest.java.before5.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinDemo {
    public static void main(String[] args) {
        System.out.println(ForkJoinPool.commonPool().getParallelism());

        System.out.println(Runtime.getRuntime().availableProcessors());


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}
