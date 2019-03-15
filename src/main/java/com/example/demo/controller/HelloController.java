package com.example.demo.controller;

import com.example.demo.entity.auto.PersonDO;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author steel
 * @datetime 2019/3/15 11:06
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    private HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("person")
    @ResponseBody
    public PersonDO helloPerson(String name) {
        PersonDO personDO = new PersonDO();
        personDO.setName(name);
        return helloService.getPerson(personDO);
    }
}
