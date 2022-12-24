package com.KrUnKy.rest.webservice.restfulwebservices;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloWorldController {

    @GetMapping(path = "/hello/{name}")
    public HelloWorldBean helloWorld(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello : %s " , name));
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

}
