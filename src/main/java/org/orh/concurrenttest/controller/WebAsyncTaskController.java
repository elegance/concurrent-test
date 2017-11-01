package org.orh.concurrenttest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * @author orh
 */
@RestController
public class WebAsyncTaskController {
    @GetMapping("/webAsyncHello")
    public WebAsyncTask<String> hello() {
        return new WebAsyncTask<>(() -> {
            return "hello";
        });
    }

    @GetMapping("/webAsyncTask1")
    public WebAsyncTask<String> webAsyncTask1() {
        long timeout = 10L * 1000; // 自定义超时时间 10 秒

        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<String>(timeout, () -> {
            Thread.sleep(2 * 1000);
            return "Hello webAsyncTask1";
        });
        return webAsyncTask;
    }

    @GetMapping("/webAsyncTask2")
    public WebAsyncTask<String> webAsyncTask2() {
        return new WebAsyncTask<String>(() -> {
           throw new RuntimeException("出错了!");
        });
    }

    @ExceptionHandler
    public String exceptionHandler(Exception e) {
        return "handler exception:" + e.getMessage();
    }
}
