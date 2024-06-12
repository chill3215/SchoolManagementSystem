package com.lechi.managementsystem.Config;

import com.lechi.managementsystem.Model.Entity.Subject;
import com.lechi.managementsystem.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private SubjectService subjectService;
    @Override
    public void run(String... args) throws Exception {


//        subjectService.add(Subject.builder()
//                        .name("Math")
//                        .room("S101")
//                        .creditPoints(6)
//                        .subjectCode("M101")
//                        .build());
//        subjectService.add(Subject.builder()
//                .name("English")
//                .room("S102")
//                .subjectCode("E102")
//                .creditPoints(4)
//                .build());;
    }
}
