package com.maze.student.Dpt;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class DptServiceImpl implements DptService {

    DptRepository dptRepository;
    DptAssembler dptAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<DptDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Dpt> dpts = dptRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(dpts.getContent()))
            return pagedResourcesAssembler.toModel(dpts, dptAssembler);

        return null;
    }

    @Override
    public DptDTO addDpt(Dpt dpt) {
        return dptAssembler.toModel(dptRepository.save(dpt));
    }

    @Override
    public DptDTO findDptById(Long id) {
        Dpt dpt = dptRepository.findById(id).orElse(null);
        if (dpt != null) {
            return dptAssembler.toModel(dpt);
        }
        return null;
    }
}
