package com.lechi.managementsystem.Model.Dto;


import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.Column;
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
public class StudentDTO {

    private Integer id;

    @NotBlank(message = "Full name has to be given")
    private String fullname;

    @NotBlank(message = "E-Mail address has to be given")
    @Email
    private String email;
    private UserRole userRole;
    private String grade;
    private String fatherName;
    private String motherName;
    private String address;
    private String phonenumber;
    private LocalDate dob;
    private Gender gender;

    @NotBlank(message = "Academic ID has to be given")
    @Column(unique = true)
    private String academicID;
    private int entryYear;
    private String nationality;

}
