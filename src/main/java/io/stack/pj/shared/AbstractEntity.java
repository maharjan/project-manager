package io.stack.pj.shared;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import java.util.Date;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@MappedSuperclass
public class AbstractEntity extends AbstractPersistable<Long> {

    @CreatedDate
    @Setter(AccessLevel.PRIVATE)
    protected Date createdDate = new Date();

    @LastModifiedDate
    @Setter(AccessLevel.PRIVATE)
    protected Date lastModifiedDate;

    @Version
    @Setter(AccessLevel.PRIVATE)
    private Long version = 0L;

    @Override
    public boolean isNew() {
        return super.isNew();
    }

    @PrePersist
    public void prePersist(){
        lastModifiedDate = new Date();
    }
}
