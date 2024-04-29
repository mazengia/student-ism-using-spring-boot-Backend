package com.maze.student.Dpt;

import com.maze.student.CertificationType.Certifications;
import com.maze.student.Department.Department;
import com.maze.student.Program.Programs;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T12:44:30+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DptMapperImpl implements DptMapper {

    @Override
    public Dpt toDpt(DptDTO dptDTO) {
        if ( dptDTO == null ) {
            return null;
        }

        Dpt dpt = new Dpt();

        dpt.setId( dptDTO.getId() );
        dpt.setDepartment( dptDTO.getDepartment() );
        dpt.setPrograms( dptDTO.getPrograms() );
        dpt.setCertifications( dptDTO.getCertifications() );

        return dpt;
    }

    @Override
    public DptDTO toDptDto(Dpt dpt) {
        if ( dpt == null ) {
            return null;
        }

        Long id = null;
        Department department = null;
        Programs programs = null;
        Certifications certifications = null;

        id = dpt.getId();
        department = dpt.getDepartment();
        programs = dpt.getPrograms();
        certifications = dpt.getCertifications();

        DptDTO dptDTO = new DptDTO( id, department, programs, certifications );

        return dptDTO;
    }
}
