package io.stack.pj.user;

import io.stack.pj.shared.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Setter
@Getter
@Entity
@Data
public class Users extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.INACTIVE;

    @Enumerated(EnumType.STRING)
    private Roles roles = Roles.REPORTER;
}
