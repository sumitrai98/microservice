package com.codeforsolution.user.service.userservice.repository;

import com.codeforsolution.user.service.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
