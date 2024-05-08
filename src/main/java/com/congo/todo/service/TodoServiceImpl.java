package com.congo.todo.service;

import com.congo.todo.entity.Todo;
import com.congo.todo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Annotation used to specify a service
public class TodoServiceImpl implements TodoService{ //Implementing the methods we have in our service interface

    @Autowired //Because we want to use methods from Db we need to connect the repo with the project
    private TodoRepo todoRepo;

    @Override //Overriding the methods we have in the service and reusing them in our implementation instead of having to start from scratch
    public List<Todo> getAllTodo() { //Return type is a list of todo
        return todoRepo.findAll(); //findAll() is a method provided by JpaRepository as it allows communication between the application database
    }

    @Override
    public void saveTodo(Todo todo) { //Does not expect any return value
        this.todoRepo.save(todo); //save() is a method provided by JpaRepository
    }

    @Override
    public Todo getTodoById(Long id) { //Return type of todo is expected
        Optional<Todo> optional = todoRepo.findById(id);
        Todo todo;
        if(optional.isPresent()) {
            todo = optional.get();
        }
        else {
            throw new RuntimeException("Todo for the id " + id + " is not found");
        }

        return todo;
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo todoFromDb = todoRepo.findById(id).get();
        todoFromDb.setTaskName(todo.getTaskName());
        todoFromDb.setDesc(todo.getDesc());
        todoRepo.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long id) {
        this.todoRepo.deleteById(id);
    }
}
