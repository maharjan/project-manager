package io.stack.pj.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found.")
public class EntityNotFoundException extends RuntimeException{

    private final String message;

    public EntityNotFoundException(final String message) {
        this.message = "Resource not found for " + message;
    }
}
