package com.example.demo.validator;
import com.example.demo.entity.Student;

public class StudentValidator {
    public void validate(Student newStudent){
        if (newStudent.getReference() == null || newStudent.getReference().isBlank()){
            throw new IllegalArgumentException("Reference is required");
        }
        if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()){
            throw new IllegalArgumentException("FirstName is required");
        }
        if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()){
            throw new IllegalArgumentException("LastName is required");
        }
        if (newStudent.getAge() == null){
            throw new IllegalArgumentException("Age is required");
        }
    }

}
