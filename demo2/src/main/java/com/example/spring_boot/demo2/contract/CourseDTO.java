package com.example.spring_boot.demo2.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO {


    // private Integer courseId;
    
    private String courseName;
    private String courseCode;
    private Integer courseCredit;
    private Integer courseFee;
    private String courseDuration;

    
 
    
}
