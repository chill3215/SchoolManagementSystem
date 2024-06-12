package com.lechi.managementsystem.Model.Dto;

import com.lechi.managementsystem.Model.Entity.Subject;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDTO {

    private Integer id;
    private String fullname;
    private String email;
    private UserRole userRole;
    private Subject subject;
    private LocalDate dob;
    private String qualification;
    private String phonenumber;
    private String gender;
    private String address;
    private String teacherNumber;
    private int entryYear;
    private String nationality;
    private String school;





}
