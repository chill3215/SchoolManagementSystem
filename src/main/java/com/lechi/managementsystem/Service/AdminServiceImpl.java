package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.Admin;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.AdminRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private UserService userService;

    @Autowired
    private AdminRepository adminRepository;

    @PostConstruct
    public void createAdmin() {
        User adminFound = userService.findByUserRole(UserRole.ADMIN);
        if (adminFound == null) {
            Admin admin = Admin.builder()
                    .fullname("admin")
                    .email("admin@gmail.com")
                    .password("admin")
                    .userRole(UserRole.ADMIN)
                    .academicID("000")
                    .build();
            adminRepository.save(admin);
        }
    }
}
