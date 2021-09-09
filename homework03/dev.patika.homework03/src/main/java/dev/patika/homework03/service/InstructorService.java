package dev.patika.homework03.service;

import dev.patika.homework03.dao.InstructorDAO;
import dev.patika.homework03.model.Instructor;

import dev.patika.homework03.model.PermanentInstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    private final InstructorDAO repository;
/*
    @Autowired
    public InstructorService(@Qualifier("instructorDAOJPA")InstructorDAO instructorInstructorDAO) {
        this.instructorInstructorDAO = instructorInstructorDAO;
    }


 */
    @Override
    public List<Instructor> findAll() {
        List<Instructor> insList = new ArrayList<>();
        Iterable<Instructor> employeeIter = repository.findAll();
        employeeIter.iterator().forEachRemaining(insList::add);
        return insList;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Instructor> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) repository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Instructor updateOnDatabase(Instructor instructor) {
        return (Instructor) repository.save(instructor);
    }

    @Transactional
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    @Transactional
    public List<PermanentInstructor> findTop3ByOrderByFixedSalaryDesc() {
        return repository.findTop3ByOrderByFixedSalaryDesc();
    }

    @Transactional
    public List<PermanentInstructor> findTop3ByOrderByFixedSalaryAsc() {
        return repository.findTop3ByOrderByFixedSalaryAsc();
    }
}
