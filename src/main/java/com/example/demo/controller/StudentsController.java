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
    List<String> studentsNames = new ArrayList<>();
    @PostMapping("/students")
    public ResponseEntity<List<String>> addStudent(@RequestBody List<Students> students) {

        listStudents.addAll(students);

        for (Students student : listStudents) {
            studentsNames.add(student.getFirstName() + " " + student.getLastName());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsNames);
    }

    @GetMapping("/students")
    public ResponseEntity<String> getAllStudents(
            @RequestHeader(value = "Accept", required = false) String accept) {
        if (accept == null || "text/plain".equals(accept)) {
            StringBuilder result = new StringBuilder();
            for (Students s : listStudents) {
                result.append(s.getFirstName())
                        .append(" ")
                        .append(s.getLastName())
                        .append("\n");
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result.toString());
        }
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body("Format non supporté");
    }
}