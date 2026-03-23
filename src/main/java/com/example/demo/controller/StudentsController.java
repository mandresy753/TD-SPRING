package com.example.demo.controller;

import com.example.demo.entity.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {
    private List<Students> listStudents = new ArrayList<>();

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody List<Students> students) {
        try {

            listStudents.addAll(students);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(listStudents);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors du traitement du POST : " + e.getMessage());
        }
    }

    @GetMapping( "/students")
    public ResponseEntity<?> getAllStudents(
            @RequestHeader(value = "Accept", required = false) String accept) {
        try {
            if (accept == null || accept.trim().isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Accept header is missing");
            }

            if ("application/json".equals(accept)) {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(listStudents);
            }

            if ("text/plain".equals(accept)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(listStudents.toString());
            }
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Unsupported Accept: " + accept);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur GET : " + e.getMessage());
        }
    }
}
