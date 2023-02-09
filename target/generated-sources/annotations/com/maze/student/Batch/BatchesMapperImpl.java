package com.maze.student.Batch;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-09T01:47:54+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class BatchesMapperImpl implements BatchesMapper {

    @Override
    public Batches toAppeal(BatchesDto batchesDto) {
        if ( batchesDto == null ) {
            return null;
        }

        Batches batches = new Batches();

        batches.setDeletedAt( batchesDto.getDeletedAt() );
        batches.setDeleted( batchesDto.isDeleted() );
        batches.setVersion( batchesDto.getVersion() );
        batches.setCreatedBy( batchesDto.getCreatedBy() );
        batches.setUpdatedBy( batchesDto.getUpdatedBy() );
        batches.setCreatedAt( batchesDto.getCreatedAt() );
        batches.setUpdatedAt( batchesDto.getUpdatedAt() );
        batches.setRemark( batchesDto.getRemark() );
        batches.setId( batchesDto.getId() );
        batches.setName( batchesDto.getName() );

        return batches;
    }

    @Override
    public BatchesDto toAppealDto(Batches batches) {
        if ( batches == null ) {
            return null;
        }

        BatchesDto batchesDto = new BatchesDto();

        batchesDto.setDeletedAt( batches.getDeletedAt() );
        batchesDto.setDeleted( batches.isDeleted() );
        batchesDto.setVersion( batches.getVersion() );
        batchesDto.setCreatedBy( batches.getCreatedBy() );
        batchesDto.setUpdatedBy( batches.getUpdatedBy() );
        batchesDto.setCreatedAt( batches.getCreatedAt() );
        batchesDto.setUpdatedAt( batches.getUpdatedAt() );
        batchesDto.setRemark( batches.getRemark() );
        batchesDto.setId( batches.getId() );
        batchesDto.setName( batches.getName() );

        return batchesDto;
    }
}
