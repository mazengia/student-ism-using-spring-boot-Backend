package com.maze.student.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
@RequiredArgsConstructor
public abstract class Auditable implements Serializable {

    @Schema(hidden = true)
    private LocalDateTime deletedAt;
    private boolean deleted=Boolean.FALSE;
    @Version()
    @Column(columnDefinition = "integer default 0")
    private long version;

    @Schema(hidden = true)
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    @Schema(hidden = true)
    @Column(name = "updated_by")
    @LastModifiedBy
    private String updatedBy;
    @Schema(hidden = true)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt=LocalDateTime.now();
    @Schema(hidden = true)
    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt=LocalDateTime.now();
    private String remark;

}
