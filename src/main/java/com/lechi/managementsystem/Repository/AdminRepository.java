package com.lechi.managementsystem.Repository;

import com.lechi.managementsystem.Model.Entity.Admin;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository<Admin>{

}
