package com.bezkoder.student.Status;

import org.springframework.hateoas.CollectionModel;

public interface StatusService {
    CollectionModel<StatusDTO> findAll(int page, int size );

    StatusDTO addStatus(Status status);

    StatusDTO findStatusById(Long id);
}
