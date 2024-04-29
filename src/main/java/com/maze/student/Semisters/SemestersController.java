package com.maze.student.Semisters;

import com.maze.student.util.PaginatedResultsRetrievedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/semesters")
@RequiredArgsConstructor
public class SemestersController implements SemestersApi {
    private final SemestersService semestersService;
    private final SemestersMapper semestersMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public SemestersDto createSemesters(SemestersDto semestersDto  ) throws IllegalAccessException {
        return semestersMapper.toSemestersDto(semestersService.createSemesters(semestersMapper.toSemesters(semestersDto)));
    }

    @Override
    public SemestersDto getSemestersById(long id) {
        return semestersMapper.toSemestersDto(semestersService.getSemestersById(id));
    }



    @Override
    public SemestersDto updateSemesters(long id, SemestersDto semestersDto, JwtAuthenticationToken token) throws IllegalAccessException {
        return semestersMapper.toSemestersDto(semestersService.updateSemesters(id, semestersMapper.toSemesters(semestersDto), token));
    }

    @Override
    public ResponseEntity<PagedModel<SemestersDto>> getAllSemesters(Pageable pageable, PagedResourcesAssembler assembler,    UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                SemestersDto.class, uriBuilder, response, pageable.getPageNumber(), semestersService.getAllSemesters(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<SemestersDto>>(assembler.toModel(semestersService.getAllSemesters(pageable).map(semestersMapper::toSemestersDto)), HttpStatus.OK);
    }
}
