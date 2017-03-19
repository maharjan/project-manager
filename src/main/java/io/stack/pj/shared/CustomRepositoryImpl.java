package io.stack.pj.shared;

import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Slf4j
public abstract class CustomRepositoryImpl<E extends AbstractEntity, R extends BaseJpaRepository<E>> extends
        QueryDslRepositorySupport implements CustomRepository<E> {

    protected R repository;

    /**
     * Creates a new {@link QueryDslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */
    public CustomRepositoryImpl(Class<E> domainClass) {
        super(domainClass);
    }

    @Override
    public Optional<E> findOptional(Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public Optional<E> findOptional(Predicate predicate) {
        return Optional.ofNullable(repository.findOne(predicate));
    }

    @PostConstruct
    public void validateBeans() {
        Assert.notNull(repository, "Repository must not be null.\nAutowire repository with Setter Injection.");
    }

    @Override
    public E findOneOrThrowNotFoundException(final Long id) {
        return findOptional(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
    }
}
