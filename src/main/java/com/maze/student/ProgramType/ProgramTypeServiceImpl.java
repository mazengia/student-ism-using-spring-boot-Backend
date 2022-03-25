package com.maze.student.ProgramType;

import com.maze.student.exception.ResourceNotFoundException;
import com.maze.student.program.ProgramDTO;
import com.maze.student.program.Programs;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class ProgramTypeServiceImpl implements ProgramTypeService {

    ProgramTypeRepository programTypeRepository;
    ProgramTypeAssembler programTypeAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<ProgramTypeDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<ProgramType> programTypes = programTypeRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(programTypes.getContent()))
            return pagedResourcesAssembler.toModel(programTypes, programTypeAssembler);

        return null;
    }

    @Override
    public ProgramTypeDTO addProgramType(ProgramType programType) {
        return programTypeAssembler.toModel(programTypeRepository.save(programType));
    }

    @Override
    public ProgramTypeDTO findProgramTypeById(Long id) {
        ProgramType programType = programTypeRepository.findById(id).orElse(null);
        if (programType != null) {
            return programTypeAssembler.toModel(programType);
        }
        return null;
    }

    @Override
    public ProgramTypeDTO deleteProgramTypeById(Long id) throws ResourceNotFoundException {
        ProgramType programType = programTypeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Program type with ID :" + id + " Not Found!")
        );
        programTypeRepository.deleteById(programType.getId());
        return programTypeAssembler.toModel(programType);
    }
}
