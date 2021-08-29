package dev.patika.homework03.dao;

import dev.patika.homework03.model.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDAO extends CrudRepository<Instructor,Integer> {
}
