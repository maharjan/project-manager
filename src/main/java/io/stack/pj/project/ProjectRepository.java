package io.stack.pj.project;

import io.stack.pj.project.impl.Projects;
import io.stack.pj.project.resource.ProjectResource;
import io.stack.pj.shared.BaseJpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface ProjectRepository extends BaseJpaRepository<Projects> {

    @Query("SELECT new io.stack.pj.project.resource.ProjectResource(pr.id, pr.name, pr.description, pr.status) FROM Projects pr")
    List<ProjectResource> findAllProjects();

    @Query("SELECT new io.stack.pj.project.resource.ProjectResource(pr.id, pr.name, pr.description, pr.status) FROM Projects pr where pr.id=?1")
    ProjectResource findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT pr FROM Projects pr where pr.id=?1")
    Projects findByIdForUpdate(long projectId);
}
