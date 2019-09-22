package com.rnd.backendspring.dao.impl;

import com.rnd.backendspring.dao.StudentDao;
import com.rnd.backendspring.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean saveStudent(Student student) {
        boolean valid = false;
        try{
            sessionFactory.getCurrentSession().save(student);
            valid = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public List<Student> listStudents() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> query = currentSession.createQuery("FROM Student", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        boolean valid = false;
        try{
            sessionFactory.getCurrentSession().delete(student);
            valid = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public List<Student> studentGetId(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        String jpql = "FROM Student s WHERE s.id=:id";
        Query<Student> query = currentSession.createQuery(jpql, Student.class);
        query.setParameter("id", student.getId());
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean valid = false;
        try{
            sessionFactory.getCurrentSession().update(student);
            valid = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return valid;
    }
}
