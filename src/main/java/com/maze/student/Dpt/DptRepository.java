package com.maze.student.Dpt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DptRepository extends JpaRepository<Dpt, Long> {
    @Override
    Optional<Dpt> findById(Long aLong);
    Page<Dpt> findAllByDepartmentId(Pageable pageable,long id);
    Page<Dpt> findAllById(Pageable pageable,long id);
}