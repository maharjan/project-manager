package io.stack.pj.project.resource;

import io.stack.pj.project.ProjectRepository;
import io.stack.pj.project.impl.Projects;
import io.stack.pj.project.impl.QProjects;
import io.stack.pj.shared.CustomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public class ProjectDslRepositoryImpl extends CustomRepositoryImpl<Projects, ProjectRepository> implements ProjectDslRepository {

    private QProjects project = QProjects.projects;

    public ProjectDslRepositoryImpl() {
        super(Projects.class);
    }

    @Lazy
    @Autowired
    public void setRepository(ProjectRepository repository) {
        this.repository = repository;
    }

}
