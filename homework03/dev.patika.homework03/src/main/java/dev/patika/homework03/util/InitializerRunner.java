package dev.patika.homework03.util;

import dev.patika.homework03.dao.CourseDAO;
import dev.patika.homework03.dao.InstructorDAO;
import dev.patika.homework03.dao.StudentDAO;
import dev.patika.homework03.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    CourseDAO courseDAO;
    @Autowired
    InstructorDAO instructorDAO;


    @Override
    public void run(String... args) throws Exception {
        courseDAO.deleteAll();
        studentDAO.deleteAll();
        instructorDAO.deleteAll();

        Instructor instructor1 = PermanentInstructor.builder().name("Dulcie").address("46646 Bonner Street").phoneNumber("701-118-3088").fixedSalary(1111).build();
        Instructor instructor2 = PermanentInstructor.builder().name("Jan").address("9 Ilene Junction").phoneNumber("387-125-0540").fixedSalary(2222).build();
        Instructor instructor4= PermanentInstructor.builder().name("Ali").address("Ilene Junction").phoneNumber("125-0540").fixedSalary(3333).build();
        Instructor instructor5 = PermanentInstructor.builder().name("Veli").address("9 Junction").phoneNumber("387-0540").fixedSalary(2422).build();
        Instructor instructor6 = PermanentInstructor.builder().name("Can").address("9 Ine Junction").phoneNumber("387-125").fixedSalary(1222).build();
        Instructor instructor7 = PermanentInstructor.builder().name("John").address("91 Ilene Junction").phoneNumber("387125-0540").fixedSalary(222).build();
        Instructor instructor3 = VisitingResearcher.builder().name("Sergeant").address("77650 Division Pass").phoneNumber("417-288-5603").hourlySalary(3333).build();

        Course course1 = Course.builder().courseName("Java").courseCode(101).creditScore(4).instructor(instructor1).build();
        Course course2 = Course.builder().courseName("C#").courseCode(101).creditScore(3).instructor(instructor2).build();
        Course course3 = Course.builder().courseName("Php").courseCode(101).creditScore(2).instructor(instructor3).build();

        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        Student student1 =Student.builder().name("Brant").birthDate(LocalDate.of(2000, 6, 25)).address("24468 Steensland Hill").gender("Female").studentCourse(courses).build();
        Student student2=Student.builder().name("Margit").birthDate(LocalDate.of(1990, 3, 13)).address("87 Hermina Pass").gender("Male").studentCourse(courses).build();
        Student student3=Student.builder().name("Filmer").birthDate(LocalDate.of(1995, 11, 2)).address("251 6th Terrace").gender("Female").studentCourse(courses).build();

        instructorDAO.save(instructor1);
        instructorDAO.save(instructor2);
        instructorDAO.save(instructor3);
        instructorDAO.save(instructor4);
        instructorDAO.save(instructor5);
        instructorDAO.save(instructor6);
        instructorDAO.save(instructor7);

        courseDAO.save(course1);
        courseDAO.save(course2);
        courseDAO.save(course3);

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        instructorDAO.findAll().forEach(instructor -> logger.info("{}", instructor));
    }
}


/*
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

 */
/*
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
 */


