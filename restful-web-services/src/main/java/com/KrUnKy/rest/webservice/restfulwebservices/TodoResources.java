package com.KrUnKy.rest.webservice.restfulwebservices;

import com.KrUnKy.rest.webservice.restfulwebservices.Entity.Todo;
import com.KrUnKy.rest.webservice.restfulwebservices.Service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TodoResources  {

    @Autowired
    private TodoHardcodedService hardcodedService;


    @GetMapping("/user/{username}/todos")
    public List<Todo> getAllTodosForUser(@PathVariable  String username){
        return hardcodedService.findAll();
    }

//    @GetMapping("/user/{username}/todos/{id}")
//    public List<Todo> (@PathVariable  String username){
//        return hardcodedService.findAll();
//    }

}
