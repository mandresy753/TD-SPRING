package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.StudentService;
import com.example.demo.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentValidator validator = new StudentValidator();
    private final StudentService service = new StudentService();

    @PostMapping("/students")
    public ResponseEntity<?> createStudents(@RequestBody List<Student> newStudents) {

        try {
            for (Student s : newStudents) {
                validator.validate(s);
            }

            return ResponseEntity.ok(service.saveAll(newStudents));

        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents() {

        return ResponseEntity.ok(service.getAll());
    }
}