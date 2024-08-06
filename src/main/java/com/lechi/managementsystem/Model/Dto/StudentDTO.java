package com.lechi.managementsystem.Model.Dto;


import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
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
    private String fullname;
    private String email;
    private UserRole userRole;
    private String grade;
    private String fatherName;
    private String motherName;
    private String address;
    private String phonenumber;
    private LocalDate dob;
    private Gender gender;
    private String studentNumber;
    private int entryYear;
    private String nationality;

}
