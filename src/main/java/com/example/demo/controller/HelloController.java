package com.example.demo.controller;

import com.example.demo.entity.auto.PersonDO;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author steel
 * @datetime 2019/3/15 11:06
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    private HelloService helloService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

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

    @RequestMapping("test/{key1}")
    @ResponseBody
    public String test(@PathVariable String key1) {
        return stringRedisTemplate.opsForValue().get(key1);
    }

    @PostMapping(value = "/image", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public PersonDO imagePerson(PersonDO personDO) {
        return personDO;
    }
}
