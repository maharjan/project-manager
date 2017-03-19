package io.stack.pj.project.impl;

import io.stack.pj.project.ProjectDao;
import io.stack.pj.project.ProjectRepository;
import io.stack.pj.project.resource.ProjectResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Slf4j
@Repository
public class ProjectDaoImpl implements ProjectDao {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectDaoImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResource findById(final Long id){
        return projectRepository.findById(id);
    }

    @Override
    public List<ProjectResource> findAll(){
        return projectRepository.findAllProjects();
    }

    @Override
    public Projects findOne(final Long id){
        return projectRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void create(Projects project){
        projectRepository.save(project);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Projects findByIdForUpdate(final Long projectId){
        return projectRepository.findByIdForUpdate(projectId);
    }
}
