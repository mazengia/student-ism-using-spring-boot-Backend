package com.maze.student.Batch;

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
public class BatchesController implements BatchesApi {
    private final BatchesService batchesService;
    private final BatchesMapper batchesMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public BatchesDto createBatches(BatchesDto batchesDto  ) throws IllegalAccessException {
        return batchesMapper.toAppealDto(batchesService.createBatches(batchesMapper.toAppeal(batchesDto)));
    }

    @Override
    public BatchesDto getBatchesById(long id) {
        return batchesMapper.toAppealDto(batchesService.getBatchesById(id));
    }



    @Override
    public BatchesDto updateBatches(long id, BatchesDto batchesDto, JwtAuthenticationToken token) throws IllegalAccessException {
        return batchesMapper.toAppealDto(batchesService.updateBatches(id, batchesMapper.toAppeal(batchesDto), token));
    }

    @Override
    public ResponseEntity<PagedModel<BatchesDto>> getAllBatches(Pageable pageable, PagedResourcesAssembler assembler, JwtAuthenticationToken token, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                BatchesDto.class, uriBuilder, response, pageable.getPageNumber(), batchesService.getAllBatches(pageable, token).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<BatchesDto>>(assembler.toModel(batchesService.getAllBatches(pageable, token).map(batchesMapper::toAppealDto)), HttpStatus.OK);
    }
}
