package com.KrUnKy.rest.webservice.restfulwebservices;

import com.KrUnKy.rest.webservice.restfulwebservices.Entity.Todo;
import com.KrUnKy.rest.webservice.restfulwebservices.Service.TodoHardcodedService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class TodoResources  {
    private final TodoHardcodedService todoHardcodedService;

    public TodoResources(TodoHardcodedService todoHardcodedService) {
        this.todoHardcodedService = todoHardcodedService;
    }

    @GetMapping("/user/{username}/todos")
    public List<Todo> getAllTodosForUser(@PathVariable  String username){
        return todoHardcodedService.findALl();
    }
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoHardcodedService.deleteById(id);
        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username , @PathVariable long id){
        return todoHardcodedService.findById(id);
    }

    @PutMapping ("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id , @RequestBody Todo todo){
        Todo todoUpdated = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping ("/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo todoUpdated = todoHardcodedService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoUpdated.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }






}
