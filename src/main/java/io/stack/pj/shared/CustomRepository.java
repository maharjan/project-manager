package io.stack.pj.shared;


import com.querydsl.core.types.Predicate;

import java.util.Optional;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
public interface CustomRepository<T extends AbstractEntity> {

    Optional<T> findOptional(Long id);

    Optional<T> findOptional(Predicate predicate);

    T findOneOrThrowNotFoundException(final Long id);

}
