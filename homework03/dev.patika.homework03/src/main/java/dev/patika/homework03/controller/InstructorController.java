package dev.patika.homework03.controller;

import dev.patika.homework03.model.Instructor;
import dev.patika.homework03.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping(value = "/instructors/{id}")
    public void deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
    }
    @GetMapping("/instructors/{id}")
    public Instructor findInstructorById(@PathVariable int id){
        return  instructorService.findById(id);
    }

    @PutMapping("/instructors")
    public Instructor updateCourse(@RequestBody Instructor instructor){
        return   instructorService.updateOnDatabase(instructor);
    }


}
