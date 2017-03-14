package io.stack.pj.record.task;

import io.stack.pj.shared.AbstractEntity;
import io.stack.pj.user.Users;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
public class TaskHistory extends AbstractEntity{

    @ManyToOne
    private Tasks task;

    private String narration;

    @ManyToOne
    private Users users;

}
