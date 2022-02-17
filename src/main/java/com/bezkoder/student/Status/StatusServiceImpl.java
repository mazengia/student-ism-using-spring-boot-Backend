package com.bezkoder.student.Status;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {

    StatusRepository statusRepository;
    StatusAssembler statusAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<StatusDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Status> statuses = statusRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(statuses.getContent()))
            return pagedResourcesAssembler.toModel(statuses, statusAssembler);

        return null;
    }

    @Override
    public StatusDTO addStatus(Status status) {
        return statusAssembler.toModel(statusRepository.save(status));
    }

    @Override
    public StatusDTO findStatusById(Long id) {
        Status status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            return statusAssembler.toModel(status);
        }
        return null;
    }
}
