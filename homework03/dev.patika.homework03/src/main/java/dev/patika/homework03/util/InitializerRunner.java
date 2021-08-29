package dev.patika.homework03.util;


import dev.patika.homework03.dao.CourseDAO;
import dev.patika.homework03.dao.InstructorDAO;
import dev.patika.homework03.dao.StudentDAO;
import dev.patika.homework03.model.Course;
import dev.patika.homework03.model.Instructor;
import dev.patika.homework03.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    CourseDAO repository;
    Course course1;
    Course course2;
    @Autowired
    StudentDAO studentDAO;
    Student student;
    Student student1;
    @Autowired
    InstructorDAO instructorDAO;
    Instructor ins;


    List<Student> stu = new ArrayList<>();
    List<Course> course = new ArrayList<>();


    @Override
    public void run(String... args) throws Exception {
       // repository.deleteAll();
        student.setS_gender("Male");
        student.setS_address("İst");
        student.setS_birthDate(LocalDate.of(2020,01,06));
        student.setS_name("ali");

        student1.setS_gender("Male");
        student1.setS_address("İstad");
        student1.setS_birthDate(LocalDate.of(2020,01,06));
        student1.setS_name("alasdi");

        course1.setCourses(stu);
        course1.setCourseCode(123);
        course1.setCreditScore(54);
        course1.setCourseName("ab");

        course2.setCourses(stu);
        course2.setCourseCode(1293);
        course2.setCreditScore(5);
        course2.setCourseName("abad");

        ins.setName("a");
        ins.setAddress("v");
        ins.setPhoneNumber("664654");
        ins.setInstructorCourse(course);

        student.setStudentCourse(course);
        stu.add(student);
        student1.setStudentCourse(course);
        stu.add(student1);


        course.add(course1);
        course.add(course2);



        //repository.save(Course.builder().courseName("Physics").courseCode(25).creditScore(4).courses(stu).instructor(ins).build());

        repository.save(Course.builder()
                .courseName("Turkish Language - 1")
                .courseCode(001)
                .creditScore(2).courses(stu)
                .instructor((Instructor) instructorDAO.save(Instructor.builder().name("ads").phoneNumber("dfwer").address("adr").instructorCourse(course).build())).build());

        repository.findAll().forEach(course -> logger.info("{}", course));



    }


}


