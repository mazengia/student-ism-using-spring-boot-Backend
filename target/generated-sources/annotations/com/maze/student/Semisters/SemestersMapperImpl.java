package com.maze.student.Semisters;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-15T14:19:52+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SemestersMapperImpl implements SemestersMapper {

    @Override
    public Semesters toSemesters(SemestersDto semestersDto) {
        if ( semestersDto == null ) {
            return null;
        }

        Semesters semesters = new Semesters();

        semesters.setDeletedAt( semestersDto.getDeletedAt() );
        semesters.setDeleted( semestersDto.isDeleted() );
        semesters.setVersion( semestersDto.getVersion() );
        semesters.setCreatedBy( semestersDto.getCreatedBy() );
        semesters.setUpdatedBy( semestersDto.getUpdatedBy() );
        semesters.setCreatedAt( semestersDto.getCreatedAt() );
        semesters.setUpdatedAt( semestersDto.getUpdatedAt() );
        semesters.setRemark( semestersDto.getRemark() );
        semesters.setId( semestersDto.getId() );
        semesters.setName( semestersDto.getName() );

        return semesters;
    }

    @Override
    public SemestersDto toSemestersDto(Semesters semesters) {
        if ( semesters == null ) {
            return null;
        }

        SemestersDto semestersDto = new SemestersDto();

        semestersDto.setDeletedAt( semesters.getDeletedAt() );
        semestersDto.setDeleted( semesters.isDeleted() );
        semestersDto.setVersion( semesters.getVersion() );
        semestersDto.setCreatedBy( semesters.getCreatedBy() );
        semestersDto.setUpdatedBy( semesters.getUpdatedBy() );
        semestersDto.setCreatedAt( semesters.getCreatedAt() );
        semestersDto.setUpdatedAt( semesters.getUpdatedAt() );
        semestersDto.setRemark( semesters.getRemark() );
        semestersDto.setId( semesters.getId() );
        semestersDto.setName( semesters.getName() );

        return semestersDto;
    }
}
