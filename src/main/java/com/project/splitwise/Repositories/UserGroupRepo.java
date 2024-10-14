package com.project.splitwise.Repositories;

import com.project.splitwise.Models.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {



}
