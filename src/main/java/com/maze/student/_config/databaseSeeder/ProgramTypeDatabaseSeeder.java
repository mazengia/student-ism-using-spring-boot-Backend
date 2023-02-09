package com.maze.student._config.databaseSeeder;

import com.maze.student.ProgramType.ProgramType;
import com.maze.student.ProgramType.ProgramTypeRepository;
import com.maze.student.ProgramType.ProgramTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProgramTypeDatabaseSeeder implements CommandLineRunner {
    private final ProgramTypeRepository programTypeRepository;
    private final ProgramTypeServiceImpl programTypeService;

    @Override
    public void run(String... args) {

        if (programTypeRepository.existsByName("Regular").equals(false)) {
            ProgramType programType = new  ProgramType();
            programType.setName("Regular");
            programTypeService.addProgramType(programType);
        }
        if (programTypeRepository.existsByName("Distance").equals(false)) {
            ProgramType programType = new  ProgramType();
            programType.setName("Distance");
            programTypeService.addProgramType(programType);
        }
        if (programTypeRepository.existsByName("Night").equals(false)) {
            ProgramType programType = new  ProgramType();
            programType.setName("Night");
            programTypeService.addProgramType(programType);
        }
    }
}