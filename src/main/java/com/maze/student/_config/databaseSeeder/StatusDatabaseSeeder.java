package com.maze.student._config.databaseSeeder;

import com.maze.student.Status.Status;
import com.maze.student.Status.StatusRepository;
import com.maze.student.Status.StatusServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class StatusDatabaseSeeder implements CommandLineRunner {
    private final StatusRepository statusRepository;
    private final StatusServiceImpl statusService;

    @SneakyThrows
    @Override
    public void run(String... args) {

        if (statusRepository.existsByName("Complete").equals(false)) {
            Status status = new Status();
            status.setName("Complete");
            statusService.addStatus(status);
        }
        if (statusRepository.existsByName("InComplete").equals(false)) {
            Status status = new Status();
            status.setName("InComplete");
            statusService.addStatus(status);
        }
        if (statusRepository.existsByName("Active").equals(false)) {
            Status status = new Status();
            status.setName("Active");
            statusService.addStatus(status);
        }
        if (statusRepository.existsByName("Withdraw").equals(false)) {
            Status status = new Status();
            status.setName("Withdraw");
            statusService.addStatus(status);
        }
    }
}