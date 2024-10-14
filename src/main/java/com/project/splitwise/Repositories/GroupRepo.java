package com.project.splitwise.Repositories;

import com.project.splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {
    Optional<Group> findById(Long id);
    Optional<Group> findByName(String name);

}
