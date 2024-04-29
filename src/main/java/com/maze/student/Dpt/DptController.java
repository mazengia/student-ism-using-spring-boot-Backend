package com.maze.student.Dpt;

import com.maze.student.util.PaginatedResultsRetrievedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/dpt")
@RequiredArgsConstructor
public class DptController  implements DptApi   {
    private final DptService dptService;
    private final DptMapper dptMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public DptDTO createDpt(DptDTO dptDTO) throws IllegalAccessException {
        return dptMapper.toDptDto(dptService.createDpt(dptMapper.toDpt(dptDTO)));
    }

    @Override
    public DptDTO getDptById(long id) {
        return dptMapper.toDptDto(dptService.getDptById(id));
    }



    @Override
    public DptDTO updateDpt(long id, DptDTO dptDTO) throws IllegalAccessException {
        return dptMapper.toDptDto(dptService.updateDpt(id, dptMapper.toDpt(dptDTO ) ));
    }

    @Override
    public ResponseEntity<PagedModel<DptDTO>> getAllDpt(Pageable pageable, PagedResourcesAssembler assembler,   UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                DptDTO.class, uriBuilder, response, pageable.getPageNumber(), dptService.getAllDpt(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<DptDTO>>(assembler.toModel(dptService.getAllDpt(pageable).map(dptMapper::toDptDto)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PagedModel<DptDTO>> getAllDptByDepartmentId(Pageable pageable, long id, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                DptDTO.class, uriBuilder, response, pageable.getPageNumber(), dptService.getAllDptByDepartmentId(pageable,id).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<DptDTO>>(assembler.toModel(dptService.getAllDptByDepartmentId(pageable,id).map(dptMapper::toDptDto)), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PagedModel<DptDTO>> getAllDptByGroup(Pageable pageable, long id, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                DptDTO.class, uriBuilder, response, pageable.getPageNumber(), dptService.getAllDptByGroup(pageable,id).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<DptDTO>>(assembler.toModel(dptService.getAllDptByGroup(pageable,id).map(dptMapper::toDptDto)), HttpStatus.OK);

    }
}
