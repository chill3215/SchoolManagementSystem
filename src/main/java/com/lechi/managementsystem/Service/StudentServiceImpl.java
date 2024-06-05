package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.StudentRepository;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;



    @Override
    public List<StudentDTO> getAll() {

         return studentRepository.findAll().stream().map(Student::getStudentDTO).collect(Collectors.toList());
    }

    @Override
    public void add(Student student) {
        student.setUserRole(UserRole.STUDENT);
        studentRepository.save(student);
    }

//    @Override
//    public StudentDTO findByEmail(String email) {
//        return studentRepository.findByEmail(email).getStudentDTO();
//    }

    @Override
    public StudentDTO getDTOById(Integer id) {
        return studentRepository.getStudentsById(id).getStudentDTO();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepository.getStudentsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(StudentDTO updatedStudent) {
        Student existingStudent = getById(updatedStudent.getId());
        if(existingStudent!=null){
            existingStudent.setFullname(updatedStudent.getFullname());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDob(updatedStudent.getDob());
            studentRepository.save(existingStudent);
        }


    }

    @Override
    public long count() {
        return studentRepository.count();
    }


}
