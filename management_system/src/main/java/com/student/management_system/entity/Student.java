package com.student.management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_management_system")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    
    @Column(name = "First-Name")
    @NotBlank(message = "First name of user is empty .")
    String firstName;

    @Column(name = "Last-Name")
    @NotEmpty(message = "Lastname is empty .")
    String lastName;

    @Column(name="Email")
    @NotEmpty(message = "email is empty .")
    String email;


    public Student(String fisrtName, String lastName, String email) {
        this.firstName = fisrtName;
        this.lastName = lastName;
        this.email = email;
    }

}
