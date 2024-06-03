package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullname;
    private LocalDate dob;
    private String email;
    private String password;
    private Gender gender;
    private String phonenumber;
    private String studentId;


    @Enumerated(EnumType.STRING)
    private UserRole userRole=UserRole.STUDENT;
}
