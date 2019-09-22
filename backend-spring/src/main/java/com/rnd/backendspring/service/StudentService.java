package com.rnd.backendspring.service;

import com.rnd.backendspring.entity.Student;

import java.util.List;

public interface StudentService {

    boolean saveStudent(Student student);
    List<Student> listStudents();
    boolean deleteStudent(Student student);
    List<Student> studentGetId(Student student);
    boolean updateStudent(Student student);
}
