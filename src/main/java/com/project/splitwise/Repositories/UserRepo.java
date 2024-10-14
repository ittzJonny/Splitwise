package com.project.splitwise.Repositories;

import com.project.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String user);
    Optional<User> findById(long user);
}
