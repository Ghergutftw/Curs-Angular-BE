package com.KrUnKy.rest.webservice.restfulwebservices;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloWorldController {

    @GetMapping(path = "/hello/{name}")
    public String helloWorld(@PathVariable String name){
        return String.format("Hello : %s", name);
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

}
