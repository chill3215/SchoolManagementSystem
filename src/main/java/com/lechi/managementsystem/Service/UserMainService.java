package com.lechi.managementsystem.Service;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;

public interface UserMainService extends MainService<User> {
    public User findByUserRole(UserRole userRole);

}
