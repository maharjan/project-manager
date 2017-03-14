package io.stack.pj.project.impl;

import io.stack.pj.project.ProjectService;
import io.stack.pj.project.resource.ProjectDetails;
import io.stack.pj.project.resource.ProjectRequest;
import io.stack.pj.project.resource.ProjectResource;
import io.stack.pj.shared.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@RestController
@RequestMapping(value = Routes.PROJECT)
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResource> getAllProjects() {
        return projectService.findAllProjects();
    }

    @GetMapping(value = "/{project_id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResource getProject(@PathVariable("project_id") String projectId) {
        return projectService.findProjectById(Long.valueOf(projectId));
    }

    @GetMapping(value = "/{project_id}/detail")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDetails getProjectDetail(@PathVariable("project_id") String projectId){
        return projectService.findDetail(Long.valueOf(projectId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@RequestBody ProjectRequest request){
        projectService.createProject(request);
    }
}
