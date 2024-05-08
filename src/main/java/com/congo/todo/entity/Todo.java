package com.congo.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Getter //Annotation used to create getters methods for our variables
@Setter //Annotation used to create setters methods for our  variables
@Entity //Used to specify in Spring application an entity that will be used for the DB
public class Todo {

    @Id //It is used by the database to specify a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Choose the method for the id
    private Long id;

    @NonNull //Ensure value will not be empty
    private String taskName;

    @NonNull
    private String desc;

    @CreatedDate //Annotation used to specify creation date for your Db and it is done so automatically by Spring Boot
    Timestamp dateCreated;
}
