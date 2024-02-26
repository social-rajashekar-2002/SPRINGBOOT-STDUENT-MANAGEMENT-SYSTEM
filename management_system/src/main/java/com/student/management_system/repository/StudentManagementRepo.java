package com.student.management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management_system.entity.Student;


public interface StudentManagementRepo extends JpaRepository<Student,Long>{

}
