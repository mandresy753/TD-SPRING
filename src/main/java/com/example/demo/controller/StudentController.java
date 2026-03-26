package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StudentController {
    List<Student> studentsInMemory = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<?> createStudents(@RequestBody List<Student> newStudents) {
        for (Student newStudent : newStudents) {
            if (newStudent.reference() == null || newStudent.reference().isBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .header("Content-Type", "text/plain")
                        .body("NewStudent.reference cannot be null");
            }
        }
        studentsInMemory.addAll(newStudents); return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentsInMemory);
    }
}
