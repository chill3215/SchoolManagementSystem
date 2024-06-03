package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    public List<User> findUsersByUserRole(UserRole userRole);

    public User findByUserRole(UserRole userRole);

    public User findByEmail(String email);


}
