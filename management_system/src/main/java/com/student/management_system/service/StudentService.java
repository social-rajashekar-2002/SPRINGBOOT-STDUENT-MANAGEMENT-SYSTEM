package com.student.management_system.service;

import java.util.List;

import com.student.management_system.entity.Student;
import com.student.management_system.exception.ResourceNotFoundException;


public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student) ;
    Student getById(Long id)throws ResourceNotFoundException;
    void updateStudent(Student object,Student student);
    void deleteById(Long id);
    List<Student> findByfirstNameContaining(String str);

}
