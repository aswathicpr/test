package com.example.spring_boot.demo2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.demo2.contract.CourseDTO;
import com.example.spring_boot.demo2.contract.Response;
import com.example.spring_boot.demo2.model.Course;

import java.util.*;
//import java.util.Map;

import org.hibernate.collection.spi.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.spring_boot.demo2.service.CourseService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@AllArgsConstructor
@RequiredArgsConstructor

public class CoursesController {

@Autowired
   CourseService courseService;
   
    @PostMapping("/addcourse")
    public CourseDTO addCourses(@RequestBody CourseDTO courseDTO ) {
     
      courseService.addCourse(courseDTO);
        
        return courseDTO;
    }

    @GetMapping("/getallcourse")
    public List<Course> getAllCourse() {
    return  courseService.getAllCourse();
       
    }

    @GetMapping("/getcourse/{courseCode}")
    public List<Course> getCourseByCode(@PathVariable String courseCode  ) {
      List<Course> out =  courseService.getByCourseCode(courseCode);

        return out;
    }

    @PutMapping("/updatecourse/{id}")
    public ResponseEntity<Response<?>>  updateCourse(@PathVariable Integer id, @RequestBody CourseDTO courseDTO) {
      ResponseEntity<Response<?>> res = courseService.updateCourseDetails(id,courseDTO);
      return res;
       //  entity;
    }

    @DeleteMapping("/delete/course")
    public ResponseEntity<Response<?>> deleteCourse(@RequestParam Integer id){
    
     ResponseEntity<Response<?>> res = courseService.deleteCourseById(id);
     
           return res;
         //  ResponseEntity.status(HttpStatus.SEE_OTHER).body(Response.builder().build());
         
         }
     
    

}


