package com.maze.student._config.databaseSeeder;

import com.maze.student.CerteficationYear.CertificationYear;
import com.maze.student.CerteficationYear.CertificationYearRepository;
import com.maze.student.CerteficationYear.CertificationYearServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class BatchDatabaseSeeder implements CommandLineRunner {
    private final CertificationYearRepository certificationYearRepository;
    private final CertificationYearServiceImpl batchesService;

    @SneakyThrows
    @Override
    public void run(String... args) {

        if (certificationYearRepository.existsByName("First Year").equals(false)) {

            CertificationYear certificationYear = new CertificationYear();
            certificationYear.setName("First Year");
            batchesService.createBatches(certificationYear);
        }
        if (certificationYearRepository.existsByName("Second Year").equals(false)) {

            CertificationYear certificationYear = new CertificationYear();
            certificationYear.setName("Second Year");
            batchesService.createBatches(certificationYear);
        }
        if (certificationYearRepository.existsByName("Third Year").equals(false)) {

            CertificationYear certificationYear = new CertificationYear();
            certificationYear.setName("Third Year");
            batchesService.createBatches(certificationYear);
        }
        if (certificationYearRepository.existsByName("Forth Year").equals(false)) {

            CertificationYear certificationYear = new CertificationYear();
            certificationYear.setName("Forth Year");
            batchesService.createBatches(certificationYear);
        }
        if (certificationYearRepository.existsByName("Fifth Year").equals(false)) {

            CertificationYear certificationYear = new CertificationYear();
            certificationYear.setName("Fifth Year");
            batchesService.createBatches(certificationYear);
        }
    }
}