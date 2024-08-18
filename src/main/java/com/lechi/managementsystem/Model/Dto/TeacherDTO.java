package com.lechi.managementsystem.Model.Dto;

import com.lechi.managementsystem.Model.Entity.Subject;
import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Full name has to be given")
    private String fullname;

    @NotBlank(message = "E-Mail address has to be given")
    @Email
    private String email;
    private UserRole userRole;
    private Subject subject;
    private LocalDate dob;
    private String qualification;
    private String phonenumber;
    private Gender gender;
    private String address;
    private String teacherNumber;
    private int entryYear;
    private String nationality;
    private String school;






}
