package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Dto.StudentDTO;
import com.lechi.managementsystem.Model.Entity.Score;
import com.lechi.managementsystem.Model.Entity.Student;

import java.util.List;

public interface StudentService extends MainService<Student, StudentDTO>{

    public List<Score> getScoreOfStudentById(Integer id);

    public void addScore(Integer id, Score score);

    public void updateScore(Integer id, Score updatedScore);

    public void deleteScore(Integer id, Integer deletedScoreId);
}
