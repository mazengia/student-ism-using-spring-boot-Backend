package com.maze.student._config.databaseSeeder;

import com.maze.student.CertificationType.CertificationRepository;
import com.maze.student.CertificationType.CertificationServiceImpl;
import com.maze.student.CertificationType.Certifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProgramDatabaseSeeder implements CommandLineRunner {
    private final CertificationRepository CertificationRepository;
    private final CertificationServiceImpl ProgramServiceImpl;

    @Override
    public void run(String... args) {

        if (CertificationRepository.existsByName("BSC").equals(false)) {
            Certifications certifications = new Certifications();
            certifications.setName("BSC");
            ProgramServiceImpl.addProgram(certifications);
        }
        if (CertificationRepository.existsByName("Bachelor Of Art").equals(false)) {
            Certifications certifications = new Certifications();
            certifications.setName("Bachelor Of Art");
            ProgramServiceImpl.addProgram(certifications);
        }
        if (CertificationRepository.existsByName("Master").equals(false)) {
            Certifications certifications = new Certifications();
            certifications.setName("Master");
            ProgramServiceImpl.addProgram(certifications);
        }
        if (CertificationRepository.existsByName("PHD").equals(false)) {
            Certifications certifications = new Certifications();
            certifications.setName("PHD");
            ProgramServiceImpl.addProgram(certifications);
        }
    }
}