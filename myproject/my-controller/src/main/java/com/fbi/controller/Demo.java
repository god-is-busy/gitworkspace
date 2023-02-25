package com.fbi.controller;

import com.fbi.service.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class Demo {

    @Resource
    PeopleService peopleService;

    @GetMapping("/hello")
    public String hello() {
        return "demo";
    }

    @GetMapping("/create")
    @ResponseBody
    public void create() {
        peopleService.create();
    }
}
