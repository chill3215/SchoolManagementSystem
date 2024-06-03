package com.lechi.managementsystem.Model.Entity;

import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
