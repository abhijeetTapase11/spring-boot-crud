package com.example.BasicJava.service;

import com.example.BasicJava.model.Student;
import com.example.BasicJava.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

//    if a student returns any book
    public Optional<Student> updateStudentBooks(String rollNo,String bookName){
        Optional<Student> studentOpt=studentRepository.findByRollNo(rollNo);
        studentOpt.ifPresent(student -> {
            student.getBooks().removeIf(book->book.getName().equals(bookName));
            studentRepository.save((student));
        });
        return studentOpt;
    }
    public void deleteStudent(String rollNo){
        Optional<Student> studentOpt=studentRepository.findByRollNo(rollNo);
//        studentOpt.ifPresent(s->logger.info("Deleting student: {}",s));
        studentOpt.ifPresent(studentRepository::delete);
    }
}
