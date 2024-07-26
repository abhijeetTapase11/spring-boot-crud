package com.example.BasicJava.controllers;

import com.example.BasicJava.model.Student;
import com.example.BasicJava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Date;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;//importing services

    @GetMapping
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();// getting all students data
    }

    @PostMapping("/issued")
    public Student addStudent(@RequestBody Student student){
        student.getBooks().forEach(book->book.setIssuedDate(new Date()));//storing data to db
        return studentService.addStudent(student);
    }

    @PutMapping("/{rollNo}/return-book")
    public Optional<Student> returnBook(@PathVariable String rollNo,@RequestParam String bookName){
        return studentService.updateStudentBooks(rollNo,bookName);//updating student's books array
    }

    @DeleteMapping("/{rollNo}")
    public void deleteStudent(@PathVariable String rollNo){
        studentService.deleteStudent(rollNo);//deleteing a student's data
    }
}
