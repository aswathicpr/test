package com.example.spring_boot.demo2.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CourseNameException.class)
    public ResponseEntity<Map<String,String>> handleCourseNameExcepton(CourseNameException exception){
        Map<String,String> errResponse =new HashMap<>();
        errResponse.put("Message", exception.getMessage());
            return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
        
    }
    @ExceptionHandler(UserIdNotFoundException.class)
    private ResponseEntity<Map<String,String>> handleUserIdNotFoundException(UserIdNotFoundException exception){
        Map<String,String> errResponse =new HashMap<>();
        errResponse.put("Message", exception.getMessage());
            return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);

    }
    

    //     @ExceptionHandler(ApplicationNotFoundException.class)
    // public ResponseEntity<Map<String, String>>handleApplicationNotFoundException(ApplicationNotFoundException ex) {

    //     Map<String, String> errorResponse = new HashMap<>();
    //     errorResponse.put("message", ex.getMessage());
    //     errorResponse.put("status","N");
    //     return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    // }

}
