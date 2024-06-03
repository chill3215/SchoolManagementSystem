package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Teacher;

public interface TeacherService {

    public void addTeacher(Teacher teacher);

    public Teacher getTeacherById(Integer id);

    public void deleteById(Integer id);
}
