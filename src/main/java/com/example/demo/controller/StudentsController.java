package com.example.demo.controller;

import com.example.demo.entity.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    private List<Students> listStudents = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<List<String>> addStudent(@RequestBody List<Students> students) {

        listStudents.addAll(students);
    List<String> studentsNames = new ArrayList<>();
    for (Students student : listStudents) {
        studentsNames.add(student.getFirstName() + " " + student.getLastName());
    }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsNames);
    }
}