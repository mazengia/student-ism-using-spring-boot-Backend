package com.maze.student.Role;

import com.maze.student.users.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    @Override
    Optional<Roles> findById(Long aLong);
    Optional<Object> findByName(ERole name);
}