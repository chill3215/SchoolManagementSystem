package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;

import java.util.List;

public interface UserService {

    public List<User> findUsersByUserRole(UserRole userRole);

    public User findByUserRole(UserRole userRole);

    public void addUser(User user);

    public User findByEmail(String email);
}
