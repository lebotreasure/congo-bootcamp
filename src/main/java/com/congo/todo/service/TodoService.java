package com.congo.todo.service;

import com.congo.todo.entity.Todo;

import java.util.List;

public interface TodoService { //Interface used to initialise the methods that we can reuse in other classes
    List <Todo> getAllTodo();
    void saveTodo(Todo todo);
    void updateTodo(Long id, Todo todo);
    Todo getTodoById(Long id);
    void deleteTodo(Long id);
}
