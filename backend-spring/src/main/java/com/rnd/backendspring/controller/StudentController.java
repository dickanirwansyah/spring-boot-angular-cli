package com.rnd.backendspring.controller;

import com.rnd.backendspring.entity.Student;
import com.rnd.backendspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = {"*"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/save-student")
    public boolean saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(value = "/list-student")
    public List<Student> listStudent(){
        return studentService.listStudents();
    }

    @DeleteMapping(value = "/delete-student/{id}")
    public boolean deleteStudent(@PathVariable("id") int id, Student student){
//        student.setId(id);
        return studentService.deleteStudent(student);
    }

    @GetMapping(value = "/get-student/{id}")
    public List<Student> getId(@PathVariable("id")int id, Student student){
        student.setId(id);
        return studentService.studentGetId(student);
    }

    @PutMapping(value = "/update-student/{id}")
    public boolean updateStudent(@PathVariable("id") int id, @RequestBody  Student student){
        student.setId(id);
        return studentService.updateStudent(student);
    }
}
