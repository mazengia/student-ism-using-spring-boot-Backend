package com.maze.student.Sections;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-09T15:25:50+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class SectionsMapperImpl implements SectionsMapper {

    @Override
    public Sections toAppeal(SectionsDto sectionsDto) {
        if ( sectionsDto == null ) {
            return null;
        }

        Sections sections = new Sections();

        sections.setDeletedAt( sectionsDto.getDeletedAt() );
        sections.setDeleted( sectionsDto.isDeleted() );
        sections.setVersion( sectionsDto.getVersion() );
        sections.setCreatedBy( sectionsDto.getCreatedBy() );
        sections.setUpdatedBy( sectionsDto.getUpdatedBy() );
        sections.setCreatedAt( sectionsDto.getCreatedAt() );
        sections.setUpdatedAt( sectionsDto.getUpdatedAt() );
        sections.setRemark( sectionsDto.getRemark() );
        sections.setId( sectionsDto.getId() );
        sections.setName( sectionsDto.getName() );

        return sections;
    }

    @Override
    public SectionsDto toAppealDto(Sections sections) {
        if ( sections == null ) {
            return null;
        }

        SectionsDto sectionsDto = new SectionsDto();

        sectionsDto.setDeletedAt( sections.getDeletedAt() );
        sectionsDto.setDeleted( sections.isDeleted() );
        sectionsDto.setVersion( sections.getVersion() );
        sectionsDto.setCreatedBy( sections.getCreatedBy() );
        sectionsDto.setUpdatedBy( sections.getUpdatedBy() );
        sectionsDto.setCreatedAt( sections.getCreatedAt() );
        sectionsDto.setUpdatedAt( sections.getUpdatedAt() );
        sectionsDto.setRemark( sections.getRemark() );
        sectionsDto.setId( sections.getId() );
        sectionsDto.setName( sections.getName() );

        return sectionsDto;
    }
}
