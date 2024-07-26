package com.example.BasicJava.service;

import com.example.BasicJava.model.Student;
import com.example.BasicJava.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@Service
public class StudentService {

//    logger to log things on console
    private static final Logger logger=LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;//importing studentRepository to make database operations

//    fetching data from studentRepository which extends MongoRepository to interact with database
    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }
//   saving data to mongoDB
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

//    if a student returns any book this function updates data
    public Optional<Student> updateStudentBooks(String rollNo,String bookName){
//      firstly find the student using roll number
        Optional<Student> studentOpt=studentRepository.findByRollNo(rollNo);

//      update books array
        studentOpt.ifPresent(student -> {
            student.getBooks().removeIf(book->book.getName().equals(bookName));
            studentRepository.save((student));
        });
        return studentOpt;
    }

//    Deleting student using roll number
    public void deleteStudent(String rollNo){
        Optional<Student> studentOpt=studentRepository.findByRollNo(rollNo);

//      logging deleted student to the console
        studentOpt.ifPresent(s->logger.info("Deleting student: {}",s));

        studentOpt.ifPresent(studentRepository::delete);
    }
}
