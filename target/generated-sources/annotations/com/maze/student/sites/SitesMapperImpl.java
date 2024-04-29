package com.maze.student.sites;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T12:44:30+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SitesMapperImpl implements SitesMapper {

    @Override
    public Sites toTraffics(SitesDtos sitesDtos) {
        if ( sitesDtos == null ) {
            return null;
        }

        Sites sites = new Sites();

        sites.setDeletedAt( sitesDtos.getDeletedAt() );
        sites.setDeleted( sitesDtos.isDeleted() );
        sites.setVersion( sitesDtos.getVersion() );
        sites.setCreatedBy( sitesDtos.getCreatedBy() );
        sites.setUpdatedBy( sitesDtos.getUpdatedBy() );
        sites.setCreatedAt( sitesDtos.getCreatedAt() );
        sites.setUpdatedAt( sitesDtos.getUpdatedAt() );
        sites.setRemark( sitesDtos.getRemark() );
        sites.setId( sitesDtos.getId() );
        sites.setName( sitesDtos.getName() );
        sites.setUrl( sitesDtos.getUrl() );

        return sites;
    }

    @Override
    public SitesDtos toTrafficsDto(Sites sites) {
        if ( sites == null ) {
            return null;
        }

        SitesDtos sitesDtos = new SitesDtos();

        sitesDtos.setDeletedAt( sites.getDeletedAt() );
        sitesDtos.setDeleted( sites.isDeleted() );
        sitesDtos.setVersion( sites.getVersion() );
        sitesDtos.setCreatedBy( sites.getCreatedBy() );
        sitesDtos.setUpdatedBy( sites.getUpdatedBy() );
        sitesDtos.setCreatedAt( sites.getCreatedAt() );
        sitesDtos.setUpdatedAt( sites.getUpdatedAt() );
        sitesDtos.setRemark( sites.getRemark() );
        sitesDtos.setId( sites.getId() );
        sitesDtos.setName( sites.getName() );
        sitesDtos.setUrl( sites.getUrl() );

        return sitesDtos;
    }
}
