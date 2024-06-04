package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        teacher.setUserRole(UserRole.TEACHER);
        teacherRepository.save(teacher);
    }

    @Override
    public Teacher findByEmail(String email) {
        return null;
    }

    @Override
    public Teacher getById(Integer id){
        return teacherRepository.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void update(Teacher updatedTeacher) {
        Teacher existingTeacher = getById(updatedTeacher.getId());
        if(existingTeacher!=null){
            existingTeacher.setFullname(updatedTeacher.getFullname());
            existingTeacher.setEmail(updatedTeacher.getEmail());
            existingTeacher.setDob(updatedTeacher.getDob());
            teacherRepository.save(existingTeacher);
        }


    }

    @Override
    public long count() {
        return teacherRepository.count();
    }
}
