package com.maze.student.Semisters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface SemestersRepository extends PagingAndSortingRepository<Semesters, Long>, JpaSpecificationExecutor<Semesters> {
    Page<Semesters> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Boolean existsByName(String name);
}
