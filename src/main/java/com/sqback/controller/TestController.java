package com.sqback.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ApiOperation(value="测试框架",notes = "输出HelloWorld")
    @GetMapping("/api/test")
    public String test() {
        return "HelloWorld";
    }

}