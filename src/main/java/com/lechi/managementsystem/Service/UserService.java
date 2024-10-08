package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Error.UserCannotBeAddedException;
import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;

import java.util.List;

public interface UserService {
    List<User> getAll();

    public User findByUserRole(UserRole userRole);

    User findByEmail(String email);

    User getById(Integer id);

    void deleteById(Integer id);

    void add(User user) throws UserCannotBeAddedException;

    long count();
}
