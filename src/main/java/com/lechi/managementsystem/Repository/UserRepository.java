package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.User;
import com.lechi.managementsystem.Model.Enum.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository<T extends User> extends JpaRepository<T,Integer> {

//    public List<User> findUsersByUserRole(UserRole userRole);

    public T findByUserRole(UserRole userRole);

    public T findByEmail(String email);

    public long count();


}
