package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> studentsInMemory = new ArrayList<>();

    public List<Student> saveAll(List<Student> students) {
        studentsInMemory.addAll(students);
        return studentsInMemory;
    }

    public List<Student> getAll(){
        return studentsInMemory;
    }
}