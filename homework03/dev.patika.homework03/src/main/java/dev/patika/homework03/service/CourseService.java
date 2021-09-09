package dev.patika.homework03.service;

import dev.patika.homework03.dao.CourseDAO;
import dev.patika.homework03.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{
    private final CourseDAO repository;

    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> employeeIter = repository.findAll();
        employeeIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)

    public Optional<Course> findById(int id) {
        return repository.findById(id);
        }



    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) repository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Optional<Course> result = findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Course updateOnDatabase(Course course) {
        return  repository.save(course);
    }

    @Transactional
    public List<Course> findByNameContaining(String name) {
        return repository.findByCourseNameContaining(name);
    }

    @Transactional
    public void deleteCourseByName(String name) {
         repository.deleteCourseByCourseName(name);
    }
}
