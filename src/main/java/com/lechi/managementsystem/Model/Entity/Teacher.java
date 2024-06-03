package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullname;
    private LocalDate dob;
    private String email;
    private String password;
    private Gender gender;
    private String phonenumber;
    private String teacherId;
    private String address;

    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.TEACHER;
}
