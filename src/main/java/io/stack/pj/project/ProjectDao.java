package io.stack.pj.project;

import io.stack.pj.project.impl.Projects;
import io.stack.pj.project.resource.ProjectResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface ProjectDao {
    ProjectResource findById(Long id);

    List<ProjectResource> findAll();

    Projects findOne(Long id);

    @Transactional(propagation = Propagation.MANDATORY)
    void create(Projects project);
}
