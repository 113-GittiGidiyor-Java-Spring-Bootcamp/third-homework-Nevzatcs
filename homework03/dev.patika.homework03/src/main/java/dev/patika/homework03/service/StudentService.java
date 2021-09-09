package dev.patika.homework03.service;

import dev.patika.homework03.dao.StudentDAO;
import dev.patika.homework03.dao.StudentGenderStatistics;
import dev.patika.homework03.model.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentDAO repository;
/*
    @Autowired
    public StudentService(@Qualifier("studentDAOJPA") StudentDAO studentStudentDAO) {
        this.studentStudentDAO = studentStudentDAO;
    }


 */
    @Override
    public List<Student> findAll() {
        List<Student> stuList = new ArrayList<>();
        Iterable<Student> studentIter = repository.findAll();
        studentIter.iterator().forEachRemaining(stuList::add);
        return stuList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(int id) {
        return  repository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) repository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Student updateOnDatabase(Student student) {
        return (Student) repository.save(student);
    }

    @Transactional(readOnly = true)
    public List<StudentGenderStatistics> getGendersWithGrouping() {
        return repository.getGendersWithGrouping();
    }
    @Transactional
    public void deleteStudentByName(String name) {
        repository.deleteByName(name);
    }
}
