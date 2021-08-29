package dev.patika.homework03.service;

import dev.patika.homework03.dao.StudentDAO;
import dev.patika.homework03.model.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public Student findById(int id) {
        return (Student) repository.findById(id).get();
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
}
