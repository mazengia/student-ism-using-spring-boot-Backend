package com.maze.student.Appeal;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-24T17:25:32+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class AppealMapperImpl implements AppealMapper {

    @Override
    public Appeal toAppeal(AppealDto appealDto) {
        if ( appealDto == null ) {
            return null;
        }

        Appeal appeal = new Appeal();

        appeal.setDeletedAt( appealDto.getDeletedAt() );
        appeal.setDeleted( appealDto.isDeleted() );
        appeal.setVersion( appealDto.getVersion() );
        appeal.setCreatedBy( appealDto.getCreatedBy() );
        appeal.setUpdatedBy( appealDto.getUpdatedBy() );
        appeal.setCreatedAt( appealDto.getCreatedAt() );
        appeal.setUpdatedAt( appealDto.getUpdatedAt() );
        appeal.setRemark( appealDto.getRemark() );
        appeal.setAppealId( appealDto.getAppealId() );
        appeal.setFileNumber( appealDto.getFileNumber() );
        appeal.setDisputedAmount( appealDto.getDisputedAmount() );
        appeal.setCourtAdjudicating( appealDto.getCourtAdjudicating() );
        appeal.setReason( appealDto.getReason() );

        return appeal;
    }

    @Override
    public AppealDto toAppealDto(Appeal appeal) {
        if ( appeal == null ) {
            return null;
        }

        AppealDto appealDto = new AppealDto();

        appealDto.setDeletedAt( appeal.getDeletedAt() );
        appealDto.setDeleted( appeal.isDeleted() );
        appealDto.setVersion( appeal.getVersion() );
        appealDto.setCreatedBy( appeal.getCreatedBy() );
        appealDto.setUpdatedBy( appeal.getUpdatedBy() );
        appealDto.setCreatedAt( appeal.getCreatedAt() );
        appealDto.setUpdatedAt( appeal.getUpdatedAt() );
        appealDto.setRemark( appeal.getRemark() );
        appealDto.setAppealId( appeal.getAppealId() );
        appealDto.setReason( appeal.getReason() );
        appealDto.setFileNumber( appeal.getFileNumber() );
        appealDto.setCourtAdjudicating( appeal.getCourtAdjudicating() );
        appealDto.setDisputedAmount( appeal.getDisputedAmount() );

        return appealDto;
    }
}
