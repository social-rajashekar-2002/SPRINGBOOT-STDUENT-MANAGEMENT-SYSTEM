package com.student.management_system.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.management_system.entity.Student;
import com.student.management_system.exception.ResourceNotFoundException;
import com.student.management_system.repository.StudentManagementRepo;
import com.student.management_system.service.StudentService;


@Service
public class StudentImplementation implements StudentService {

    private StudentManagementRepo studentManagementRepo;

    public StudentImplementation(StudentManagementRepo studentManagementRepo) {
        this.studentManagementRepo = studentManagementRepo;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentManagementRepo.findAll();
    }



    @Override
    public void saveStudent(Student student){
        studentManagementRepo.save(student);
    }


    @Override
    public Student getById(Long id) throws ResourceNotFoundException{
        try{
            return studentManagementRepo.findById(id).get();
        }catch(Exception e){
            throw new ResourceNotFoundException("id object not found");
        }
        

    }



    @Override
    public void updateStudent(Student object, Student student) {
        object.setFirstName(student.getFirstName());
        object.setEmail(student.getEmail());
        object.setLastName(student.getLastName());
        studentManagementRepo.save(object);
    }


    @Override
    public void deleteById(Long id) {
        studentManagementRepo.deleteById(id);
    }


    @Override
    public List<Student> findByfirstNameContaining(String str) {
        List<Student> objects=studentManagementRepo.findAll();
        List<Student> outputList=new ArrayList<>();
        for(Student i:objects){
            if ( i.getFirstName().contains(str) ){
                outputList.add(i);
            }
        }
        return outputList;
    }



    
    
}
