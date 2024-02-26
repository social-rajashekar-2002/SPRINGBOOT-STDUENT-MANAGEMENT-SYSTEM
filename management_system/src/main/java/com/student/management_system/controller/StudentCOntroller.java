package com.student.management_system.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.management_system.entity.Student;
import com.student.management_system.exception.ResourceNotFoundException;
import com.student.management_system.service.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentCOntroller {

    private StudentService studentService;

    public StudentCOntroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    private String getAllStudent(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/add")
    private String addStudent(Model model){
        Student object=new Student();
        model.addAttribute("object", object);
        return "form";
    }

    @PostMapping("/students")
    private String getAllStudent(@Valid @ModelAttribute("object") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    private String getStudentByIdForEdit(@PathVariable("id") Long Id, Model model) throws ResourceNotFoundException{
        Student object=studentService.getById(Id);
        model.addAttribute("object", object);
        return "updateform";
    }

    @PostMapping("/students/update/{id}")
    private String updateStudentById(@PathVariable("id")Long id,@Valid @ModelAttribute("object") Student student) throws ResourceNotFoundException{
        Student object=studentService.getById(id);
        studentService.updateStudent(object,student);
        return "redirect:/students";
    }


    @GetMapping("/students/delete/{id}")
    private String deleteById(@PathVariable("id") Long Id, Model model) throws ResourceNotFoundException{
        Student object=studentService.getById(Id);
        studentService.deleteById(Id);
        return "redirect:/students";
    }

    @PostMapping("/students/search")
    private String search(@RequestParam("search") String search,Model model){
        List<Student> students= studentService.findByfirstNameContaining(search);
        model.addAttribute("students", students);
        return "students";
    }



    @PostMapping("/foo")
    private ResponseEntity<Student> testing(@Valid @RequestBody Student object){
        return ResponseEntity.ok().body(object);
    }
    
}
