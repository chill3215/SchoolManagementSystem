package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Error.UserCannotBeUpdatedException;
import com.lechi.managementsystem.Model.Dto.TeacherDTO;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.TeacherRepository;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UserRepository<User> userRepository;

    @Override
    public List<TeacherDTO> getAll() {
        return teacherRepository.findAll().stream().map(Teacher::getTeacherDTO).collect(Collectors.toList());
    }

    @Override
    public void add(Teacher teacher) throws UserCannotBeAddedException {
        if(userRepository.findByEmail(teacher.getEmail())!=null){
            throw new UserCannotBeAddedException("This email has been used", "Please try again with another E-Mail address" );
        }
        else{
            teacher.setUserRole(UserRole.TEACHER);
            teacher.setPassword(RandomPasswordGenerator.generatePassword());
            teacherRepository.save(teacher);
        }
    }

    @Override
    public Teacher getById(Integer id){
        return teacherRepository.getTeacherById(id);
    }
    public TeacherDTO getDTOById(Integer id){
        return teacherRepository.getTeacherById(id).getTeacherDTO();
    }

    @Override
    public void deleteById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void update(TeacherDTO updatedTeacher) throws UserCannotBeUpdatedException{
        Teacher existingTeacher = getById(updatedTeacher.getId());
        User userWithSameEMail = userRepository.findByEmail(updatedTeacher.getEmail());
        if(!Objects.equals(userWithSameEMail.getId(), existingTeacher.getId())){
            throw new UserCannotBeUpdatedException("This E-Mail address has been used", "Please update the user with another E-Mail address");
        }
        existingTeacher.setFullname(updatedTeacher.getFullname());
        existingTeacher.setEmail(updatedTeacher.getEmail());
        existingTeacher.setDob(updatedTeacher.getDob());
        existingTeacher.setSubject(updatedTeacher.getSubject());
        existingTeacher.setId(updatedTeacher.getId());
        existingTeacher.setQualification(updatedTeacher.getQualification());
        existingTeacher.setPhonenumber(updatedTeacher.getPhonenumber());
        existingTeacher.setEntryYear(updatedTeacher.getEntryYear());
        existingTeacher.setSchool(updatedTeacher.getSchool());
        existingTeacher.setGender(updatedTeacher.getGender());
        teacherRepository.save(existingTeacher);
    }

    @Override
    public long count() {
        return teacherRepository.count();
    }
}
