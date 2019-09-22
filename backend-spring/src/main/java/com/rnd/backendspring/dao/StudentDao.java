package com.rnd.backendspring.dao;

import com.rnd.backendspring.entity.Student;

import java.util.List;

public interface StudentDao {

    boolean saveStudent(Student student);
    List<Student> listStudents();
    boolean deleteStudent(Student student);
    List<Student> studentGetId(Student student);
    boolean updateStudent(Student student);
}
