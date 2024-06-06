package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    public boolean existsBySubjectCode(String code);

    public void deleteById(Integer id);

    public Optional<Subject> findById(Integer id);
}
