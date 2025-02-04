package com.example.spring_boot.demo2.service;

import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.spring_boot.demo2.contract.CourseDTO;
import com.example.spring_boot.demo2.contract.Response;
import com.example.spring_boot.demo2.exception.CourseNameException;
import com.example.spring_boot.demo2.exception.UserIdNotFoundException;
import com.example.spring_boot.demo2.model.Course;
import com.example.spring_boot.demo2.repository.CourseRepository;

import lombok.AllArgsConstructor;
// import org.modelmapper.*;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
// @NoArgsConstructor
public class CourseService {

    @Autowired
    private  CourseRepository courseRepository;
  
    private final ModelMapper mapper;

    public Course addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        if(!courseRepository.existsByCourseName(courseDTO.getCourseName())){

        course.setCourseName(courseDTO.getCourseName());
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseCredit(courseDTO.getCourseCredit());
        course.setCourseFee(courseDTO.getCourseFee());
        course.setCourseDuration(courseDTO.getCourseDuration());

       return courseRepository.save(course);

     }
         else throw new CourseNameException(courseDTO.getCourseName());
    }



    public List<Course> getAllCourse() {
     return  courseRepository.findAll();
         //  return null;
    }



    public List<Course> getByCourseCode(String courseCode) {
      
        List<Course> out= courseRepository.findByCourseCode(courseCode);

         return out;
    }



    public ResponseEntity<Response<?>> updateCourseDetails(Integer id, CourseDTO courseDTO) {


     //   ModelMapper mapper = new ModelMapper();
     Course course = courseRepository.findBycourseId(id);
     if(course==null)
        {
            return ResponseEntity.badRequest()
            .body(Response.builder().payload(courseDTO).message("Cannot found the course id "+id).build());
        }
         else if((id.equals(course.getCourseId()))) //
            {
                System.out.println(courseDTO);

            mapper.map(courseDTO, course);
                courseRepository.save(course);
             //  return ResponseEntity.status(HttpStatus.OK).body(Response.builder().payload(course).message("updated").build());
             return ResponseEntity.badRequest()
             .body(Response.builder().payload(course).message("updated").build());

            }

            return null;
           
        //   else if(!(id.equals(course.getCourseId()))){
        //  //  return  ResponseEntity.badRequest().body(new Response<>("Bad request", null));
        //  return ResponseEntity.badRequest()
        //  .body(Response.builder().payload(courseDTO).message("Bad request").build());

        }



    public ResponseEntity<Response<?>> deleteCourseById(Integer courseId) {
        
        if (courseRepository.existsBycourseId(courseId)) {
            courseRepository.deleteById(courseId);
            
           
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(Response.builder().payload(courseId).message("Deleted with id ").build());
        
        }
       else throw new  UserIdNotFoundException(courseId);
    }
       
}
        /* demo check
                public ResponseEntity<String> updateCoursDetails(Integer id, CourseDTO courseDTO){

                return ResponseEntity.ok("created");
                
            }*/
              

    

