package com.maze.student.Sections.Traffics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface TrafficRepository extends PagingAndSortingRepository<Traffics, Long>, JpaSpecificationExecutor<Traffics> {
    Page<Traffics> findAllByOrderByCreatedAtDesc(Pageable pageable);

}
