package com.maze.student._config.databaseSeeder;

import com.maze.student.Program.Programs;
import com.maze.student.Program.ProgramRepository;
import com.maze.student.Program.ProgramServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProgramTypeDatabaseSeeder implements CommandLineRunner {
    private final ProgramRepository programRepository;
    private final ProgramServiceImpl programTypeService;

    @Override
    public void run(String... args) {

        if (programRepository.existsByName("Regular").equals(false)) {
            Programs programs = new Programs();
            programs.setName("Regular");
            programTypeService.addProgramType(programs);
        }
        if (programRepository.existsByName("Distance").equals(false)) {
            Programs programs = new Programs();
            programs.setName("Distance");
            programTypeService.addProgramType(programs);
        }
        if (programRepository.existsByName("Night").equals(false)) {
            Programs programs = new Programs();
            programs.setName("Night");
            programTypeService.addProgramType(programs);
        }
    }
}