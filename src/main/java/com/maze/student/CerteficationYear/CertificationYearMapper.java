package com.maze.student.CerteficationYear;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificationYearMapper {
    CertificationYear toAppeal(CertificationYearDto certificationYearDto);
    CertificationYearDto toAppealDto(CertificationYear certificationYear);
}
