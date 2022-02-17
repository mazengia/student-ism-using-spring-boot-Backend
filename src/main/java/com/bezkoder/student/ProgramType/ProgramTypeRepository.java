package com.bezkoder.student.ProgramType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramTypeRepository extends JpaRepository<ProgramType, Long> {
    @Override
    Optional<ProgramType> findById(Long aLong);
}