package com.maze.student._config.databaseSeeder;

import com.maze.student.Sections.Sections;
import com.maze.student.Sections.SectionsRepository;
import com.maze.student.Sections.SectionsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class SectionsDatabaseSeeder implements CommandLineRunner {
    private final SectionsRepository sectionsRepository;
    private final SectionsServiceImpl sectionsService;

    @SneakyThrows
    @Override
    public void run(String... args) {

        if (sectionsRepository.existsByName("A").equals(false)) {

            Sections sections = new Sections();
            sections.setName("A");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("B").equals(false)) {

            Sections sections = new Sections();
            sections.setName("B");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("C").equals(false)) {

            Sections sections = new Sections();
            sections.setName("C");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("D").equals(false)) {

            Sections sections = new Sections();
            sections.setName("D");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("E").equals(false)) {

            Sections sections = new Sections();
            sections.setName("E");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("F").equals(false)) {

            Sections sections = new Sections();
            sections.setName("F");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("G").equals(false)) {

            Sections sections = new Sections();
            sections.setName("G");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("H").equals(false)) {

            Sections sections = new Sections();
            sections.setName("H");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("I").equals(false)) {

            Sections sections = new Sections();
            sections.setName("I");
            sectionsService.createSections(sections);
        }
        if (sectionsRepository.existsByName("J").equals(false)) {

            Sections sections = new Sections();
            sections.setName("J");
            sectionsService.createSections(sections);
        }
    }
}