package com.hasan.controllers;

import com.hasan.models.Owner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {

    private static final String template = "Hello, %s!";

//    @RequestMapping("/greeting2")
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(, name));
//    }

    @RequestMapping("/owner")
    public String test(@RequestParam(value="name", defaultValue="testOwner") String name){
        Owner user = new Owner(name, 22);
        return "Owner 1 " + user.getName() + " " +  user.getAge();
    }
}