package com.example.demo.controller;

import com.example.demo.entity.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    private List<Students> listStudents = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody List<Students> students) {
        listStudents.addAll(students);
        return ResponseEntity.status(HttpStatus.CREATED).body(listStudents);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlePostError(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erreur POST invalide : " + e.getMessage());
    }
}
