package com.maze.student.Status;

 import com.maze.student.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface StatusService {
    CollectionModel<StatusDTO> findAll(int page, int size );

    StatusDTO addStatus(Status status);

    StatusDTO findStatusById(Long id);
    StatusDTO deleteById(Long id) throws ResourceNotFoundException;

}
