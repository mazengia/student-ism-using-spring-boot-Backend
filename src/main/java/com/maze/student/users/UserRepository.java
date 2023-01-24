package com.maze.student.users;

import com.maze.student.Appeal.Appeal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<SystemUsers, Long>, JpaSpecificationExecutor<Appeal> {
    Page<SystemUsers> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Optional<SystemUsers> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}