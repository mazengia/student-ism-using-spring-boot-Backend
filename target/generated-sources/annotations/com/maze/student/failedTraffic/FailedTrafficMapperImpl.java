package com.maze.student.failedTraffic;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T12:44:30+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FailedTrafficMapperImpl implements FailedTrafficMapper {

    @Override
    public FailedTraffics toTraffics(FailedTrafficDtos failedTrafficDtos) {
        if ( failedTrafficDtos == null ) {
            return null;
        }

        FailedTraffics failedTraffics = new FailedTraffics();

        failedTraffics.setDeletedAt( failedTrafficDtos.getDeletedAt() );
        failedTraffics.setDeleted( failedTrafficDtos.isDeleted() );
        failedTraffics.setVersion( failedTrafficDtos.getVersion() );
        failedTraffics.setCreatedBy( failedTrafficDtos.getCreatedBy() );
        failedTraffics.setUpdatedBy( failedTrafficDtos.getUpdatedBy() );
        failedTraffics.setCreatedAt( failedTrafficDtos.getCreatedAt() );
        failedTraffics.setUpdatedAt( failedTrafficDtos.getUpdatedAt() );
        failedTraffics.setRemark( failedTrafficDtos.getRemark() );
        failedTraffics.setId( failedTrafficDtos.getId() );
        failedTraffics.setFailedSite( failedTrafficDtos.getFailedSite() );
        failedTraffics.setFailedLinkType( failedTrafficDtos.getFailedLinkType() );
        failedTraffics.setFailedReason( failedTrafficDtos.getFailedReason() );
        failedTraffics.setReportedTo( failedTrafficDtos.getReportedTo() );
        failedTraffics.setFailedAt( failedTrafficDtos.getFailedAt() );
        failedTraffics.setFixedAt( failedTrafficDtos.getFixedAt() );

        return failedTraffics;
    }

    @Override
    public FailedTrafficDtos toTrafficsDto(FailedTraffics failedTraffics) {
        if ( failedTraffics == null ) {
            return null;
        }

        FailedTrafficDtos failedTrafficDtos = new FailedTrafficDtos();

        failedTrafficDtos.setDeletedAt( failedTraffics.getDeletedAt() );
        failedTrafficDtos.setDeleted( failedTraffics.isDeleted() );
        failedTrafficDtos.setVersion( failedTraffics.getVersion() );
        failedTrafficDtos.setCreatedBy( failedTraffics.getCreatedBy() );
        failedTrafficDtos.setUpdatedBy( failedTraffics.getUpdatedBy() );
        failedTrafficDtos.setCreatedAt( failedTraffics.getCreatedAt() );
        failedTrafficDtos.setUpdatedAt( failedTraffics.getUpdatedAt() );
        failedTrafficDtos.setRemark( failedTraffics.getRemark() );
        failedTrafficDtos.setId( failedTraffics.getId() );
        failedTrafficDtos.setFailedSite( failedTraffics.getFailedSite() );
        failedTrafficDtos.setFailedLinkType( failedTraffics.getFailedLinkType() );
        failedTrafficDtos.setFailedReason( failedTraffics.getFailedReason() );
        failedTrafficDtos.setReportedTo( failedTraffics.getReportedTo() );
        failedTrafficDtos.setFailedAt( failedTraffics.getFailedAt() );
        failedTrafficDtos.setFixedAt( failedTraffics.getFixedAt() );

        return failedTrafficDtos;
    }
}
