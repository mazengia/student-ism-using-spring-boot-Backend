package com.maze.student.Status;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface StatusAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    StatusDTO updateStatus(@PathVariable long id, @RequestBody Status status);

    @GetMapping("/{id}")
    ResponseEntity<StatusDTO> findStatusById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<StatusDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    StatusDTO addStatus(@RequestBody Status status);

}
