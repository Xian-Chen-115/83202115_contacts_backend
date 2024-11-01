package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Administrator
 * 2023/8/13 10:35
 */
@RestController
public class WebController {

    @RequestMapping
    public String hellO(){
        return "HelLo亲哥哥哥";
    }

}