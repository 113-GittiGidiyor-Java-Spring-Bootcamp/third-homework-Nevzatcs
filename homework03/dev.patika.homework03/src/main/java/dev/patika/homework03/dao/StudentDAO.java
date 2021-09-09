package dev.patika.homework03.dao;

import dev.patika.homework03.model.Course;
import dev.patika.homework03.model.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO extends CrudRepository<Student, Integer> {
    @Query(nativeQuery = true, value = "select (CASE gender when 'Male' then 'Male' ELSE 'Female' end) as gender, count(st.gender) as count from Student st GROUP BY st.gender")
    List<StudentGenderStatistics> getGendersWithGrouping();

    List<Student> deleteByName(String name);
}
