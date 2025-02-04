package com.example.spring_boot.demo2.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.spring_boot.demo2.contract.Response;
import com.example.spring_boot.demo2.model.Course;


@Repository

public interface CourseRepository extends JpaRepository<Course, Integer>{

   // List<Course> findByCourseName(Integer courseName);
boolean existsByCourseName(String courseName);

List<Course> findByCourseCode(String courseCode);

boolean existsBycourseId(Integer id);
Course findBycourseId(Integer id);



// Course deleteBycourseId(Integer courseId);


//   void deleteById(Integer id);
  



//boolean findByCourseName(String courseName);

 
}
