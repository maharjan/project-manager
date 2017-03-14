package io.stack.pj.record.task;

import io.stack.pj.shared.AbstractEntity;
import io.stack.pj.user.impl.Users;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class TaskHistory extends AbstractEntity{

    @ManyToOne
    private Tasks task;

    private String narration;

    @ManyToOne
    private Users users;

}
