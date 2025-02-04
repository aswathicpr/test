package com.example.spring_boot.demo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private String courseCode;
    private Integer courseCredit;
    private Integer courseFee;
    private String courseDuration;

   
    
   /* public Course(int courseid, String coursename, float coursefee, String courseduration) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.coursefee = coursefee;
        this.courseduration = courseduration;
    }

    public int getCourseid() {
        return courseid;
    }
    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
    public String getCoursename() {
        return coursename;
    }
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    public float getCoursefee() {
        return coursefee;
    }
    public void setCoursefee(float coursefee) {
        this.coursefee = coursefee;
    }
    public String getCourseduration() {
        return courseduration;
    }
    public void setCourseduration(String courseduration) {
        this.courseduration = courseduration;
    }
*/
}
