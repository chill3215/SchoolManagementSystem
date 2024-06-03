package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private UserMainService userService;



    @PostConstruct
    public void createAdmin() {
        User adminFound = userService.findByUserRole(UserRole.ADMIN);
        if (adminFound == null) {
            User admin = User.builder()
                    .fullname("admin")
                    .email("admin@gmail.com")
                    .password("admin")
                    .userRole(UserRole.ADMIN)
                    .build();
            userService.add(admin);
        }
    }
}
