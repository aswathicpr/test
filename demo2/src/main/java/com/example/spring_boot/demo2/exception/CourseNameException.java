package com.example.spring_boot.demo2.exception;

public class CourseNameException extends RuntimeException {
    
    public CourseNameException(String course){
        super("Course with " + course +" name already exists");
    } 
    
}
