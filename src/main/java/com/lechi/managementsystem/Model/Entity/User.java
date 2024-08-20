package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Enum.Gender;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Year;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Full name has to be given")
    private String fullname;

    private LocalDate dob;

    @NotBlank(message = "Email has to be given")
    @Email
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "Academic ID has to be given")
    private String academicID;

    private String password;

    private String address;

    private Gender gender;

    private String phonenumber;

    private int entryYear;

    private String nationality;


    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
