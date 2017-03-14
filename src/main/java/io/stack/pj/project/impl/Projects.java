package io.stack.pj.project.impl;

import io.stack.pj.project.ProjectStatus;
import io.stack.pj.shared.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class Projects extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    private Date closedDate;

    private String url;

    @Enumerated(EnumType.STRING)
    private ProjectStatus status=ProjectStatus.ACTIVE;
}
