package com.example.BasicJava.repository;

import com.example.BasicJava.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,String> {
    Optional<Student> findByRollNo(String rollNo);
}
