package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Error.UserCannotBeUpdatedException;
import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Entity.Score;
import com.lechi.managementsystem.Model.Entity.Student;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.StudentRepository;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository<User> userRepository;



    @Override
    public List<StudentDTO> getAll() {
         return studentRepository.findAll().stream().map(Student::getStudentDTO).collect(Collectors.toList());
    }

    @Override
    public void add(Student student) throws UserCannotBeAddedException {
        if(userRepository.findByEmail(student.getEmail())!=null){
            throw new UserCannotBeAddedException("This email has been used", "Please try again with another E-Mail address" );
        }
        else{
            if(student.getEntryYear()==0) student.setEntryYear(LocalDate.now().getYear());
            student.setUserRole(UserRole.STUDENT);
            student.setPassword(RandomPasswordGenerator.generatePassword());
            studentRepository.save(student);
        }
    }

    @Override
    public StudentDTO getDTOById(Integer id) {
        return studentRepository.getStudentById(id).getStudentDTO();
    }

    @Override
    public Student getById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void update(StudentDTO updatedStudent) throws UserCannotBeUpdatedException {
        Student existingStudent = getById(updatedStudent.getId());
        User userWithSameEMail = userRepository.findByEmail(updatedStudent.getEmail());
        if(!Objects.equals(userWithSameEMail.getId(), existingStudent.getId())){
            throw new UserCannotBeUpdatedException("This E-Mail address has been used", "Please update the user with another E-Mail address");
        }
        existingStudent.setFullname(updatedStudent.getFullname());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setGrade(updatedStudent.getGrade());
        existingStudent.setFatherName(updatedStudent.getFatherName());
        existingStudent.setMotherName(updatedStudent.getMotherName());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setPhonenumber(updatedStudent.getPhonenumber());
        existingStudent.setGender(updatedStudent.getGender());
        existingStudent.setAcademicID(updatedStudent.getAcademicID());
        existingStudent.setEntryYear(updatedStudent.getEntryYear());
        existingStudent.setEntryYear(updatedStudent.getEntryYear());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setNationality(updatedStudent.getNationality());
        studentRepository.save(existingStudent);
    }

    @Override
    public long count() {
        return studentRepository.count();
    }


    @Override
    public List<Score> getScoreOfStudentById(Integer id) {
        return studentRepository.getStudentById(id).getResults();
    }

    public Score getScoreByScoreId(Integer studentId, Integer scoreId) {
        return studentRepository.getStudentById(studentId).getResults().stream()
                .filter(score1 -> (Objects.equals(score1.getScoreId(), scoreId))).findAny().orElse(null);
    }

    public void addScore(Integer studentId, Score score){
        Student foundStudent = studentRepository.getStudentById(studentId);
        List<Score> result= foundStudent.getResults();
        result.add(score);
        foundStudent.setResults(result);
        studentRepository.save(foundStudent);
    }

    public void updateScore(Integer id, Score updatedScore) {
        Student foundStudent = studentRepository.getStudentById(id);
        if(foundStudent !=null){
            List<Score> foundResults = foundStudent.getResults();
            Optional<Score> foundScore = foundResults.stream()
                    .filter(score -> (Objects.equals(score.getScoreId(), updatedScore.getScoreId())))
                    .findAny();
            foundScore.ifPresent(score -> score.setValue(updatedScore.getValue()));
            studentRepository.save(foundStudent);
        }
    }

    public void deleteScore(Integer id, Integer deletedScoreId){
        Student foundStudent = studentRepository.getStudentById(id);
        List<Score> newResults = foundStudent.getResults().stream()
                .filter(score -> (score.getScoreId() != deletedScoreId))
                .toList();
        foundStudent.setResults(newResults);
        studentRepository.save(foundStudent);
    }
}
