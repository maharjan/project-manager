package io.stack.pj.advice;

import io.stack.pj.shared.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> methodNotAllowed(final HttpRequestMethodNotSupportedException hrm, final HttpServletRequest
            request) {
        if (request != null) {
            log.error("Method not allowed {}", hrm.getMessage());
            return new ResponseEntity(new ErrorResponse("Sorry, your request failed! Remarks: Method " + request.getMethod() + " not allowed for " + request.getRequestURI()
                    + ".", request.getRequestURI()), HttpStatus.METHOD_NOT_ALLOWED);
        }
        return new ResponseEntity(new ErrorResponse("Sorry, your request failed. Remarks: Method not allowed.", null), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> missingRequestParameter(final MissingServletRequestParameterException msrp,
                                                                 final HttpServletRequest request) {
        log.error("Missing request parameter.", msrp);
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ErrorResponse(msrp.getMessage(), request.getRequestURI()), status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> uncheckedError(final Exception exp, final HttpServletRequest request) {
        log.error("Error ", exp);
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponse("Sorry, your request failed!", request.getRequestURI()), status);
    }
}
