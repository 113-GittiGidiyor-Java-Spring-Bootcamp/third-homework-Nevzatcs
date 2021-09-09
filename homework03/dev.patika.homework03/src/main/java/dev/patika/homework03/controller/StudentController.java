package dev.patika.homework03.controller;

import dev.patika.homework03.dao.StudentGenderStatistics;
import dev.patika.homework03.model.Course;
import dev.patika.homework03.model.Student;
import dev.patika.homework03.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping(value = "/students/deleteById/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Student with id: " + id + " is deleted...";
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findCourseById(@PathVariable int id) {
        Optional<Student> resultOptional = studentService.findById(id);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
       return studentService.updateOnDatabase(student);
    }
    @GetMapping("/students/getGendersWithGrouping")
    public List<StudentGenderStatistics> getGendersWithGrouping(){
        return studentService.getGendersWithGrouping();
    }

    @GetMapping(value = "/students/deleteByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
        return "Deleted";
    }

}
