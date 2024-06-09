package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Dto.TeacherDTO;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAll() {

        return teacherRepository.findAll().stream().map(Teacher::getTeacherDTO).collect(Collectors.toList());
    }

    @Override
    public void add(Teacher teacher) {
        teacher.setUserRole(UserRole.TEACHER);
        teacherRepository.save(teacher);
    }
//
//    @Override
//    public TeacherDTO findByEmail(String email) {
//
//        return teacherRepository.findByEmail(email).getTeacherDTO();
//    }

    @Override
    public Teacher getById(Integer id){
        return teacherRepository.getById(id);
    }
    public TeacherDTO getDTOById(Integer id){
        return teacherRepository.getById(id).getTeacherDTO();
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void update(TeacherDTO updatedTeacher) {
        Teacher existingTeacher = getById(updatedTeacher.getId());
        if(existingTeacher!=null){
            existingTeacher.setFullname(updatedTeacher.getFullname());
            existingTeacher.setEmail(updatedTeacher.getEmail());
            existingTeacher.setDob(updatedTeacher.getDob());
            existingTeacher.setSubject(updatedTeacher.getSubject());
            teacherRepository.save(existingTeacher);
        }


    }

    @Override
    public long count() {
        return teacherRepository.count();
    }
}
