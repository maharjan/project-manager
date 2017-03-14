package io.stack.pj.shared;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface CustomRepository<T> extends JpaRepository<T, Long>,JpaSpecificationExecutor<T> {

}
