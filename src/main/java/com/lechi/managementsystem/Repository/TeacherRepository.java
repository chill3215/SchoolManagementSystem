package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    public Teacher getTeacherById(Integer id);

    public long count();

}
