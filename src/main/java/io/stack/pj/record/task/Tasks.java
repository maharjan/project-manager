package io.stack.pj.record.task;

import io.stack.pj.project.impl.Projects;
import io.stack.pj.shared.AbstractEntity;
import io.stack.pj.user.impl.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Tasks extends AbstractEntity {

    @ManyToOne
    private Projects project;

    @Column(nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.BACKLOG;

    private String remarks;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "task_assignee", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<Users> taskAssignee;

    @CreatedBy
    @ManyToOne
    private Users createdBy;

    @ManyToOne
    private Users owner;
}
