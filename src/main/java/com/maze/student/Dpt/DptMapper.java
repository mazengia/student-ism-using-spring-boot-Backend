package com.maze.student.Dpt;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DptMapper {
    Dpt toDpt(DptDTO dptDTO);
    DptDTO toDptDto(Dpt dpt);
}
