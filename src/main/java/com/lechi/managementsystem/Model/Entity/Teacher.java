package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Dto.TeacherDTO;
import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Subject subject;

    private String qualification;

    private int graduationYear;

    private String teacherNumber;

    @ManyToMany
    private List<Student> students;

    public TeacherDTO getTeacherDTO(){
        return TeacherDTO.builder()
                .fullname(getFullname())
                .email(getEmail())
                .id(getId())
                .graduationYear(graduationYear)
                .qualification(qualification)
                .gender(getGender())
                .dob(getDob())
                .userRole(UserRole.TEACHER)
                .subject(subject)
                .address(getAddress())
                .phonenumber(getPhonenumber())
                .build();
    }

}
