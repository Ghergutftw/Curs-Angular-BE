package com.KrUnKy.rest.webservice.restfulwebservices.Service;

import com.KrUnKy.rest.webservice.restfulwebservices.Entity.Todo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public abstract class TodoHardcodedService implements JpaRepository<Todo, Integer> {

    private static List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0 ;

    static{
        todos.add(new Todo(++idCounter,"Madalin","Learn to Dance", new Date(),false));
        todos.add(new Todo(++idCounter,"Madalin","Learn Python", new Date(),false));
        todos.add(new Todo(++idCounter,"Madalin","Learn React", new Date(),false));
    }



}
