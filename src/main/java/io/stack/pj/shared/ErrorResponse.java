package io.stack.pj.shared;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Getter
public class ErrorResponse implements Serializable {

    private final String message;
    private final String path;

    public ErrorResponse(final String message, final String path) {
        this.message = message;
        this.path=path;
    }
}
