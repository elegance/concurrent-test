package org.orh.concurrenttest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author orh
 */
@RestController
public class DemoController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
