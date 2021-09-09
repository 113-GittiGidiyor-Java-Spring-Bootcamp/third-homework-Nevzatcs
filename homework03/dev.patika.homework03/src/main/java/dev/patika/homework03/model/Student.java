package dev.patika.homework03.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// implemented according to requirements
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;

    @ManyToMany
    private List<Course> studentCourse = new ArrayList<>();



}