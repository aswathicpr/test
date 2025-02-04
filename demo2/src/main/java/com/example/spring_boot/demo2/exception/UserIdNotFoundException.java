package com.example.spring_boot.demo2.exception;

public class UserIdNotFoundException extends RuntimeException {
  
    public UserIdNotFoundException(Integer courseId){
        super("Course id "+courseId+" not found");
    }

}
