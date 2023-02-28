package com.fbi.controller;

import com.fbi.domain.People;
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
        return "index";
    }

    @GetMapping("/create")
    @ResponseBody
    public void create() {
        peopleService.create();
    }

    @GetMapping("/query")
    public String query(People people) {
        People query = peopleService.query(people);
        return "demo";
    }
}
