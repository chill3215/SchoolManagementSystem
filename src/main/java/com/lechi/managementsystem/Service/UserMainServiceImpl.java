package com.lechi.managementsystem.Service;


import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import com.lechi.managementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findUsersByUserRole(UserRole userRole) {
        return userRepository.findUsersByUserRole(userRole);
    }

    @Override
    public User findByUserRole(UserRole userRole) {
        return userRepository.findByUserRole(userRole);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }


}
