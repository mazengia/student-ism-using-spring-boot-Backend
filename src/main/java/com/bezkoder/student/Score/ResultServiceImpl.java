package com.bezkoder.student.Score;

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
        Page<ScoreRecord> scoreRecords = resultRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(scoreRecords.getContent()))
            return pagedResourcesAssembler.toModel(scoreRecords, resultAssembler);

        return null;
    }

    @Override
    public ResultDTO addScore(ScoreRecord scoreRecord) {
        return resultAssembler.toModel(resultRepository.save(scoreRecord));
    }

    @Override
    public ResultDTO findScoreById(Long id) {
        ScoreRecord scoreRecord = resultRepository.findById(id).orElse(null);
        if (scoreRecord != null) {
            return resultAssembler.toModel(scoreRecord);
        }
        return null;
    }
}
