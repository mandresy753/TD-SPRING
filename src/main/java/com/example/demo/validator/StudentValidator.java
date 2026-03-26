package com.example.demo.validator;

import com.example.demo.entity.Student;
import org.apache.coyote.BadRequestException;

public class StudentValidator {
    public void referenceValidate(Student newStudent) throws BadRequestException {
        if (newStudent.getReference() == null || newStudent.getReference().isBlank()){
            throw new BadRequestException("Reference is required");
        }
        if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()){
            throw new BadRequestException("FirstName is required");
        }
        if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()){
            throw new BadRequestException("LastName is required");
        }
        if (newStudent.getAge() == null){
            throw new BadRequestException("Age is required");
        }
    }

}
