package io.stack.pj.project;

import io.stack.pj.project.resource.ProjectDetails;
import io.stack.pj.project.resource.ProjectRequest;
import io.stack.pj.project.resource.ProjectResource;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface ProjectService {

    ProjectResource findProjectById(Long projectId);

    List<ProjectResource> findAllProjects();

    ProjectDetails findDetail(Long projectId);

    void createProject(ProjectRequest request);

    void updateProject(ProjectRequest request, Long projectId);

    void closeProject(Long projectId, String remarks);
}
