package org.orh.concurrenttest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author orh
 */
@RestController
public class CallableController {

    @GetMapping("/callableHello")
    public Callable<String> callableHello() {
        return () -> "hello";
    }


    @GetMapping("/callable1")
    public Callable<String> callable1() {
        return () -> {
            Thread.sleep(2*1000);
            return "hello, 2000 ms later!";
        };
    }

    @GetMapping("/callable2")
    public Callable<User> callable2() {
        return () -> {
            Thread.sleep(2*1000);
            return new User("poxi哥");
        };
    }

    class User {
        User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;
    }
}
