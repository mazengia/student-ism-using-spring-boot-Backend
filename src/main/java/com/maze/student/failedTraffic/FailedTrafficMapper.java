package com.maze.student.failedTraffic;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FailedTrafficMapper {
    FailedTraffics toTraffics(FailedTrafficDtos failedTrafficDtos);
    FailedTrafficDtos toTrafficsDto(FailedTraffics failedTraffics);
}
