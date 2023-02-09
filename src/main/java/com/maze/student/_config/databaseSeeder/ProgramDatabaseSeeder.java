package com.maze.student._config.databaseSeeder;

import com.maze.student.program.ProgramRepository;
import com.maze.student.program.ProgramServiceImpl;
import com.maze.student.program.Programs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProgramDatabaseSeeder implements CommandLineRunner {
    private final ProgramRepository ProgramRepository;
    private final ProgramServiceImpl ProgramServiceImpl;

    @Override
    public void run(String... args) {

        if (ProgramRepository.existsByName("BSC").equals(false)) {
            Programs programs = new Programs();
            programs.setName("BSC");
            ProgramServiceImpl.addProgram(programs);
        }
        if (ProgramRepository.existsByName("Bachelor Of Art").equals(false)) {
            Programs programs = new Programs();
            programs.setName("Bachelor Of Art");
            ProgramServiceImpl.addProgram(programs);
        }
        if (ProgramRepository.existsByName("Master").equals(false)) {
            Programs programs = new Programs();
            programs.setName("Master");
            ProgramServiceImpl.addProgram(programs);
        }
        if (ProgramRepository.existsByName("PHD").equals(false)) {
            Programs programs = new Programs();
            programs.setName("PHD");
            ProgramServiceImpl.addProgram(programs);
        }
    }
}