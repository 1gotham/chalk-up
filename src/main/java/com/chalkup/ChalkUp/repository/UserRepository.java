package com.chalkup.ChalkUp.repository;

import com.chalkup.ChalkUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User deleteUserById(Long id);

    User findByUsername(String username);
    User findByEmail(String email);
    User existsByUsername(String username);
    User existsByEmail(String email);

}
