package com.maze.student.CerteficationYear;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T15:25:51+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class CertificationYearMapperImpl implements CertificationYearMapper {

    @Override
    public CertificationYear toAppeal(CertificationYearDto certificationYearDto) {
        if ( certificationYearDto == null ) {
            return null;
        }

        CertificationYear certificationYear = new CertificationYear();

        certificationYear.setDeletedAt( certificationYearDto.getDeletedAt() );
        certificationYear.setDeleted( certificationYearDto.isDeleted() );
        certificationYear.setVersion( certificationYearDto.getVersion() );
        certificationYear.setCreatedBy( certificationYearDto.getCreatedBy() );
        certificationYear.setUpdatedBy( certificationYearDto.getUpdatedBy() );
        certificationYear.setCreatedAt( certificationYearDto.getCreatedAt() );
        certificationYear.setUpdatedAt( certificationYearDto.getUpdatedAt() );
        certificationYear.setRemark( certificationYearDto.getRemark() );
        certificationYear.setId( certificationYearDto.getId() );
        certificationYear.setName( certificationYearDto.getName() );

        return certificationYear;
    }

    @Override
    public CertificationYearDto toAppealDto(CertificationYear certificationYear) {
        if ( certificationYear == null ) {
            return null;
        }

        CertificationYearDto certificationYearDto = new CertificationYearDto();

        certificationYearDto.setDeletedAt( certificationYear.getDeletedAt() );
        certificationYearDto.setDeleted( certificationYear.isDeleted() );
        certificationYearDto.setVersion( certificationYear.getVersion() );
        certificationYearDto.setCreatedBy( certificationYear.getCreatedBy() );
        certificationYearDto.setUpdatedBy( certificationYear.getUpdatedBy() );
        certificationYearDto.setCreatedAt( certificationYear.getCreatedAt() );
        certificationYearDto.setUpdatedAt( certificationYear.getUpdatedAt() );
        certificationYearDto.setRemark( certificationYear.getRemark() );
        certificationYearDto.setId( certificationYear.getId() );
        certificationYearDto.setName( certificationYear.getName() );

        return certificationYearDto;
    }
}
