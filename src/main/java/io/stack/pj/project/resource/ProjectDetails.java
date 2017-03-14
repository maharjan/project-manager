package io.stack.pj.project.resource;

import io.stack.pj.project.ProjectStatus;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@Builder
public class ProjectDetails implements Serializable {

    private long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private String url;
    private Date createdDate;
    private String createdBy;
}
