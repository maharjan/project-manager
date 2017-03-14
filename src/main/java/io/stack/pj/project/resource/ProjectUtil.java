package io.stack.pj.project.resource;

import io.stack.pj.project.impl.Projects;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public final class ProjectUtil {

    public static ProjectDetails convertToDetail(final Projects project){
        return ProjectDetails.builder()
                .id(project.getId())
                .createdDate(project.getCreatedDate())
                .name(project.getName())
                .description(project.getDescription())
                .status(project.getStatus())
                .url(project.getUrl())
                .build();
    }
    private ProjectUtil() {
    }
}
