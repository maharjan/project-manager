package io.stack.pj.project;

import io.stack.pj.project.resource.ProjectDetails;
import io.stack.pj.project.resource.ProjectRequest;
import io.stack.pj.project.resource.ProjectResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface ProjectService {
    ProjectResource findProjectById(Long projectId);

    List<ProjectResource> findAllProjects();

    ProjectDetails findDetail(Long projectId);

    @Transactional
    void createProject(ProjectRequest request);
}
