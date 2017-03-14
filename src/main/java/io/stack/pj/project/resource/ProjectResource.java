package io.stack.pj.project.resource;

import io.stack.pj.project.ProjectStatus;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
public class ProjectResource implements Serializable {

    private long id;
    private String name;
    private String description;
    private ProjectStatus status;

    public ProjectResource(long id, String name, String description, ProjectStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
}
