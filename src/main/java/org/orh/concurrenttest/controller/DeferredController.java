package org.orh.concurrenttest.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * DeferredResult: 即延迟的结果,即延迟发送结果; 起始和Callable类似,但是可以使其他线程协作来通知用户
 *
 * @author orh
 */
@RestController
public class DeferredController {
    private Queue<DeferredResult> queue;

    public DeferredController() {
        queue = new ConcurrentLinkedDeque<>();
    }

    @GetMapping("/deferredMessage")
    public DeferredResult<String> newMessage() {
        // 注意要有 设定超时时间 的习惯 - 及时 503 防止 滚雪球
        long timeout = 30 * 1000;
        DeferredResult<String> deferredResult = new DeferredResult<>(timeout);
        deferredResult.onCompletion(() -> {
            if (!queue.isEmpty()) {
                queue.remove();
            }
        });
        deferredResult.onTimeout(() -> queue.remove(deferredResult));
        queue.add(deferredResult);
        System.out.println("return deferredResult...");
        return deferredResult;
    }


    @Scheduled(fixedRate = 5 * 1000)
    public void pushMessage() {
        System.out.println("pushMessage method invoke...");
        Iterator<DeferredResult> iterator = queue.iterator();
        while (iterator.hasNext()) {
            iterator.next().setResult("new deferred message:" + LocalDate.now());
        }
    }
}
