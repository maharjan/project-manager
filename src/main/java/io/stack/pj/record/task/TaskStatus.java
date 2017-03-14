package io.stack.pj.record.task;

import java.io.Serializable;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public enum TaskStatus implements Serializable {

    BACKLOG, ON_PROGRESS, QA, COMPLETED, CANCELED;
}
