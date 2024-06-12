package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Subject;
import com.lechi.managementsystem.Model.Entity.Teacher;
import com.lechi.managementsystem.Repository.SubjectRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public void add(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void update(Subject updatedSubject) {
        Subject existingSubject = subjectRepository.findById(updatedSubject.getId()).orElse(null);
        if(existingSubject!=null){
            existingSubject.setName(updatedSubject.getName());
            existingSubject.setRoom(updatedSubject.getRoom());
            existingSubject.setSubjectCode(updatedSubject.getSubjectCode());
            existingSubject.setCreditPoints(updatedSubject.getCreditPoints());
            subjectRepository.save(existingSubject);
        }
    }

    @Override
    public Subject getById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public long count() {
        return subjectRepository.count();
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }



    @PostConstruct
    public void addInitialSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjects.add(Subject.builder()
                .name("Math")
                .room("S101")
                .creditPoints(6)
                .subjectCode("M101")
                .build());
        subjects.add(Subject.builder()
                .name("English")
                .room("S102")
                .creditPoints(4)
                .subjectCode("E102")
                .build());
        subjects.add(Subject.builder()
                .name("Chemistry")
                .room("C103")
                .creditPoints(4)
                .subjectCode("C103")
                .build());
        subjects.add(Subject.builder()
                .name("Physics")
                .room("P104")
                .creditPoints(4)
                .subjectCode("P104")
                .build());



        subjects.forEach(subject -> {
            if(!subjectRepository.existsBySubjectCode(subject.getSubjectCode()))
                subjectRepository.save(subject);
            });

    }


}
