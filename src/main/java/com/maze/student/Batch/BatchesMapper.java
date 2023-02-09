package com.maze.student.Batch;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BatchesMapper {
    Batches toAppeal(BatchesDto batchesDto);
    BatchesDto toAppealDto(Batches batches);
}
