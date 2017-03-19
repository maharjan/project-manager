package io.stack.pj.shared;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@NoRepositoryBean
public interface BaseJpaRepository<E extends AbstractEntity> extends PagingAndSortingRepository<E, Long>, QueryDslPredicateExecutor<E> {
}
