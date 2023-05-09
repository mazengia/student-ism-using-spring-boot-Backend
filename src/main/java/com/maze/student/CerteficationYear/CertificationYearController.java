package com.maze.student.CerteficationYear;

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
@RequestMapping("/api/v1/batches")
@RequiredArgsConstructor
public class CertificationYearController implements CertificationYearApi {
    private final CertificationYearService certificationYearService;
    private final CertificationYearMapper certificationYearMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public CertificationYearDto createBatches(CertificationYearDto certificationYearDto) throws IllegalAccessException {
        return certificationYearMapper.toAppealDto(certificationYearService.createBatches(certificationYearMapper.toAppeal(certificationYearDto)));
    }

    @Override
    public CertificationYearDto getBatchesById(long id) {
        return certificationYearMapper.toAppealDto(certificationYearService.getBatchesById(id));
    }



    @Override
    public CertificationYearDto updateBatches(long id, CertificationYearDto certificationYearDto, JwtAuthenticationToken token) throws IllegalAccessException {
        return certificationYearMapper.toAppealDto(certificationYearService.updateBatches(id, certificationYearMapper.toAppeal(certificationYearDto), token));
    }

    @Override
    public ResponseEntity<PagedModel<CertificationYearDto>> getAllBatches(Pageable pageable, PagedResourcesAssembler assembler,  UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                CertificationYearDto.class, uriBuilder, response, pageable.getPageNumber(), certificationYearService.getAllBatches(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<CertificationYearDto>>(assembler.toModel(certificationYearService.getAllBatches(pageable).map(certificationYearMapper::toAppealDto)), HttpStatus.OK);
    }
}
