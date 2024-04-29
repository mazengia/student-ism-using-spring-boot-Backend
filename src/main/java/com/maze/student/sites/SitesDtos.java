package com.maze.student.sites;

import com.maze.student.util.Auditable;
import lombok.Data;

@Data
public class SitesDtos extends Auditable {
    private Long id;
    private String name;
    private  String url;
}
