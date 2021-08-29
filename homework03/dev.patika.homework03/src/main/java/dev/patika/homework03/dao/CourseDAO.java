package dev.patika.homework03.dao;

import dev.patika.homework03.model.Course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDAO extends CrudRepository<Course,Integer> {
}
