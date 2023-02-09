package com.maze.student.Score;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class ResultServiceImpl implements ResultService {

    ResultRepository resultRepository;
    ResultAssembler resultAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<ResultDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Results> scoreRecords = resultRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(scoreRecords.getContent()))
            return pagedResourcesAssembler.toModel(scoreRecords, resultAssembler);

        return null;
    }

    @Override
    public ResultDTO addScore(Results results) {
        return resultAssembler.toModel(resultRepository.save(results));
    }

    @Override
    public ResultDTO findScoreById(Long id) {
        Results results = resultRepository.findById(id).orElse(null);
        if (results != null) {
            return resultAssembler.toModel(results);
        }
        return null;
    }
}
