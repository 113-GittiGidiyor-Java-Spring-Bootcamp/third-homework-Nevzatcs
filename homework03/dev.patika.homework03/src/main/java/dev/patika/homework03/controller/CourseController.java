package dev.patika.homework03.controller;

import dev.patika.homework03.dao.CourseDAO;
import dev.patika.homework03.model.Course;
import dev.patika.homework03.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course saveCourses(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping(value = "/courses/deleteById/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Course with id: " + " is deleted...";
    }
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id) {
        Optional<Course> resultOptional = courseService.findById(id);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return   courseService.updateOnDatabase(course);
    }

    @GetMapping("/courses/findByNameContaining/{name}")
    public List<Course> findByNameContaining(@PathVariable String name){
        return courseService.findByNameContaining(name);
    }

    @GetMapping(value = "/courses/deleteByName/{name}")
    public String deleteByName(@PathVariable String name){
        courseService.deleteCourseByName(name);
        return "Course with name : " + name + " is deleted";
    }
}
