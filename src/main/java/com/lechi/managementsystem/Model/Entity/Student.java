package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    private String grade;

    @ManyToMany
    private List<Subject> subjects;

    private String fatherName;

    private String motherName;

    private String studentNumber;

    @ElementCollection
    private List<Score> results;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;

    public StudentDTO getStudentDTO(){
        return StudentDTO.builder()
                .fullname(getFullname())
                .email(getEmail())
                .id(getId())
                .grade(grade)
                .userRole(UserRole.STUDENT)
                .fatherName(fatherName)
                .motherName(motherName)
                .dob(getDob())
                .gender(getGender())
                .phonenumber(getPhonenumber())
                .studentNumber(studentNumber)
                .entryYear(getEntryYear())
                .nationality(getNationality())
                .build();
    }
}
