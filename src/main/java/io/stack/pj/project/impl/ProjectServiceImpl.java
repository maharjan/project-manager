package io.stack.pj.project.impl;

import io.stack.pj.project.ProjectDao;
import io.stack.pj.project.ProjectService;
import io.stack.pj.project.resource.ProjectDetails;
import io.stack.pj.project.resource.ProjectRequest;
import io.stack.pj.project.resource.ProjectResource;
import io.stack.pj.project.resource.ProjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Slf4j
@Service
class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public ProjectResource findProjectById(final Long projectId){
        return projectDao.findById(projectId);
    }

    @Override
    public List<ProjectResource> findAllProjects(){
        return projectDao.findAll();
    }

    @Override
    public ProjectDetails findDetail(final Long projectId){
        final Projects projects = projectDao.findOne(projectId);
        return ProjectUtil.convertToDetail(projects);
    }

    @Override
    @Transactional
    public void createProject(final ProjectRequest request){
        final Projects project = new Projects();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setUrl(request.getUrl());

        projectDao.create(project);
    }
}
