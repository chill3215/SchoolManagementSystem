package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Enum.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends UserRepository<Student> {

    public Student getStudentsById(Integer id);

    public List<Student> findAllByUserRole(UserRole userRole);
}
