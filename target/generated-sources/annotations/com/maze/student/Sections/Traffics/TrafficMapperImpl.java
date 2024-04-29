package com.maze.student.Sections.Traffics;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T12:44:30+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TrafficMapperImpl implements TrafficMapper {

    @Override
    public Traffics toTraffics(TrafficDtos trafficDtos) {
        if ( trafficDtos == null ) {
            return null;
        }

        Traffics traffics = new Traffics();

        traffics.setDeletedAt( trafficDtos.getDeletedAt() );
        traffics.setDeleted( trafficDtos.isDeleted() );
        traffics.setVersion( trafficDtos.getVersion() );
        traffics.setCreatedBy( trafficDtos.getCreatedBy() );
        traffics.setUpdatedBy( trafficDtos.getUpdatedBy() );
        traffics.setCreatedAt( trafficDtos.getCreatedAt() );
        traffics.setUpdatedAt( trafficDtos.getUpdatedAt() );
        traffics.setRemark( trafficDtos.getRemark() );
        traffics.setId( trafficDtos.getId() );
        traffics.setEightTime( trafficDtos.getEightTime() );
        traffics.setEightTimeTraffic( trafficDtos.getEightTimeTraffic() );
        traffics.setFortiethTime( trafficDtos.getFortiethTime() );
        traffics.setFortiethTimeTraffic( trafficDtos.getFortiethTimeTraffic() );
        traffics.setEighteenTime( trafficDtos.getEighteenTime() );
        traffics.setEighteenTimeTraffic( trafficDtos.getEighteenTimeTraffic() );
        traffics.setDescription( trafficDtos.getDescription() );
        traffics.setFixedAt( trafficDtos.getFixedAt() );

        return traffics;
    }

    @Override
    public TrafficDtos toTrafficsDto(Traffics traffics) {
        if ( traffics == null ) {
            return null;
        }

        TrafficDtos trafficDtos = new TrafficDtos();

        trafficDtos.setDeletedAt( traffics.getDeletedAt() );
        trafficDtos.setDeleted( traffics.isDeleted() );
        trafficDtos.setVersion( traffics.getVersion() );
        trafficDtos.setCreatedBy( traffics.getCreatedBy() );
        trafficDtos.setUpdatedBy( traffics.getUpdatedBy() );
        trafficDtos.setCreatedAt( traffics.getCreatedAt() );
        trafficDtos.setUpdatedAt( traffics.getUpdatedAt() );
        trafficDtos.setRemark( traffics.getRemark() );
        trafficDtos.setId( traffics.getId() );
        trafficDtos.setEightTime( traffics.getEightTime() );
        trafficDtos.setEightTimeTraffic( traffics.getEightTimeTraffic() );
        trafficDtos.setFortiethTime( traffics.getFortiethTime() );
        trafficDtos.setFortiethTimeTraffic( traffics.getFortiethTimeTraffic() );
        trafficDtos.setEighteenTime( traffics.getEighteenTime() );
        trafficDtos.setEighteenTimeTraffic( traffics.getEighteenTimeTraffic() );
        trafficDtos.setDescription( traffics.getDescription() );
        trafficDtos.setFixedAt( traffics.getFixedAt() );

        return trafficDtos;
    }
}
