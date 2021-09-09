package dev.patika.homework03.controller;

import dev.patika.homework03.model.Course;
import dev.patika.homework03.model.Instructor;
import dev.patika.homework03.model.PermanentInstructor;
import dev.patika.homework03.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class InstructorController {
    InstructorService instructorService;


    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructors(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @GetMapping(value = "/instructors/deleteById/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Instructor with id: " + id +" is deleted...";
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findCourseById(@PathVariable int id) {
        Optional<Instructor> resultOptional = instructorService.findById(id);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/instructors")
    public Instructor updateCourse(@RequestBody Instructor instructor){
        return   instructorService.updateOnDatabase(instructor);
    }
    @GetMapping(value = "/instructors/deleteByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        instructorService.deleteByName(name);
        return "Deleted";
    }

    @GetMapping(value = "/instructors/findTop3Salary")
    public List<PermanentInstructor> findTop3ByOrderByFixedSalaryDesc(){
        return instructorService.findTop3ByOrderByFixedSalaryDesc();
    }

    @GetMapping(value = "/instructors/findLast3Salary")
    public List<PermanentInstructor> findTop3ByOrderByFixedSalaryAsc (){
        return instructorService.findTop3ByOrderByFixedSalaryAsc();
    }
}
