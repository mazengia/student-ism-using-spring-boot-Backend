package com.maze.student.Sections.Traffics;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrafficMapper {
    Traffics toTraffics(TrafficDtos trafficDtos);
    TrafficDtos toTrafficsDto(Traffics traffics);
}
