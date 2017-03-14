package io.stack.pj.record.issue;

import io.stack.pj.shared.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@Data
public class IssueHistory extends AbstractEntity{

    @ManyToOne
    private Issues issues;

    @Column(nullable = false)
    private String narration;

}
