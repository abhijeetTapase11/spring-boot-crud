package com.example.BasicJava.repository;

import com.example.BasicJava.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;//Optional class for null check

//using MongoRepository to interact with mongoDB for student database
public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findByRollNo(String rollNo);
}
