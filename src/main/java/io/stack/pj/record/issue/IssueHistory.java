package io.stack.pj.record.issue;

import io.stack.pj.shared.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
public class IssueHistory extends AbstractEntity{

    @ManyToOne
    private Issues issues;

    @Column(nullable = false)
    private String narration;

}
