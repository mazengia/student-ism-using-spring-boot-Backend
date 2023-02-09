package com.maze.student._config.databaseSeeder;

import com.maze.student.Semisters.Semesters;
import com.maze.student.Semisters.SemestersRepository;
import com.maze.student.Semisters.SemestersServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class SemesterDatabaseSeeder implements CommandLineRunner {
    private final SemestersRepository semestersRepository;
    private final SemestersServiceImpl semestersService;

    @SneakyThrows
    @Override
    public void run(String... args) {

        if (semestersRepository.existsByName("First Semester").equals(false)) {
            Semesters semesters = new Semesters();
            semesters.setName("First Semester");
            semestersService.createSemesters(semesters);
        }
        if (semestersRepository.existsByName("Second Semester").equals(false)) {
            Semesters semesters = new Semesters();
            semesters.setName("Second Semester");
            semestersService.createSemesters(semesters);
        }
        if (semestersRepository.existsByName("Third Semester").equals(false)) {
            Semesters semesters = new Semesters();
            semesters.setName("Third Semester");
            semestersService.createSemesters(semesters);
        }
    }
}