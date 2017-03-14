package io.stack.pj.record.issue;

import io.stack.pj.shared.AbstractEntity;
import io.stack.pj.user.impl.Users;
import lombok.Getter;
import lombok.Setter;
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
public class Issues extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @CreatedBy
    @ManyToOne
    private Users createdBy;

    @Enumerated(EnumType.STRING)
    private IssueLevel level=IssueLevel.NORMAL;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "issue_assignee", joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<Users> issueAssignee;
}
