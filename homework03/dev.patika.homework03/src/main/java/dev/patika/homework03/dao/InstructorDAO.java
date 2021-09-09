package dev.patika.homework03.dao;

import dev.patika.homework03.model.Instructor;
import dev.patika.homework03.model.PermanentInstructor;
import dev.patika.homework03.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorDAO extends CrudRepository<Instructor,Integer> {
    List<Instructor> deleteByName(String name);


    List<PermanentInstructor> findTop3ByOrderByFixedSalaryDesc();


    List<PermanentInstructor> findTop3ByOrderByFixedSalaryAsc();

}
