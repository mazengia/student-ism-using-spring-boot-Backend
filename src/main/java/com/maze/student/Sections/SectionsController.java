package com.maze.student.Sections;

import com.maze.student._config.util.PaginatedResultsRetrievedEvent;
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
@RequestMapping("/api/v1/Sections")
@RequiredArgsConstructor
public class SectionsController implements SectionsApi {
    private final SectionsService sectionsService;
    private final SectionsMapper sectionsMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public SectionsDto createSections(SectionsDto sectionsDto) throws IllegalAccessException {
        return sectionsMapper.toAppealDto(sectionsService.createSections(sectionsMapper.toAppeal(sectionsDto)));
    }

    @Override
    public SectionsDto getSectionsById(long id) {
        return sectionsMapper.toAppealDto(sectionsService.getSectionsById(id));
    }



    @Override
    public SectionsDto updateSections(long id, SectionsDto sectionsDto, JwtAuthenticationToken token) throws IllegalAccessException {
        return sectionsMapper.toAppealDto(sectionsService.updateSections(id, sectionsMapper.toAppeal(sectionsDto), token));
    }

    @Override
    public ResponseEntity<PagedModel<SectionsDto>> getAllSections(Pageable pageable, PagedResourcesAssembler assembler,   UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                SectionsDto.class, uriBuilder, response, pageable.getPageNumber(), sectionsService.getAllSections(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<SectionsDto>>(assembler.toModel(sectionsService.getAllSections(pageable).map(sectionsMapper::toAppealDto)), HttpStatus.OK);
    }
}
