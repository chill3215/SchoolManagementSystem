package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student getStudentsById(Integer id);
}
