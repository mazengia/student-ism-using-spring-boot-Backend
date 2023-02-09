package com.maze.student._config.databaseSeeder;

import com.maze.student.Batch.Batches;
import com.maze.student.Batch.BatchesRepository;
import com.maze.student.Batch.BatchesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class BatchDatabaseSeeder implements CommandLineRunner {
    private final BatchesRepository batchesRepository;
    private final BatchesServiceImpl batchesService;

    @SneakyThrows
    @Override
    public void run(String... args) {

        if (batchesRepository.existsByName("First Year").equals(false)) {

            Batches batches = new Batches();
            batches.setName("First Year");
            batchesService.createBatches(batches);
        }
        if (batchesRepository.existsByName("Second Year").equals(false)) {

            Batches batches = new Batches();
            batches.setName("Second Year");
            batchesService.createBatches(batches);
        }
        if (batchesRepository.existsByName("Third Year").equals(false)) {

            Batches batches = new Batches();
            batches.setName("Third Year");
            batchesService.createBatches(batches);
        }
        if (batchesRepository.existsByName("Forth Year").equals(false)) {

            Batches batches = new Batches();
            batches.setName("Forth Year");
            batchesService.createBatches(batches);
        }
        if (batchesRepository.existsByName("Fifth Year").equals(false)) {

            Batches batches = new Batches();
            batches.setName("Fifth Year");
            batchesService.createBatches(batches);
        }
    }
}