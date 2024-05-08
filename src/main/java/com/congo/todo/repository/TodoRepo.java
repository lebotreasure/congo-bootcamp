package com.congo.todo.repository;

import com.congo.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Annotation used in Spring to specify that this is a repository
public interface TodoRepo extends JpaRepository<Todo, Long> { //JpaRepository facilitates communication between application and database
    /* The entity class is used to for the database
    Long is used to tell the application the data type for id variable
    */
}
