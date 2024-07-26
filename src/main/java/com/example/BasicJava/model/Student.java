package com.example.BasicJava.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String rollNo;
    private List<Book> books;

    @Data
    public static class Book{
        private String name;
        private Date issuedDate;
    }
}
