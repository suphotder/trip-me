package com.example.server.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {
    private static final Logger logger = LogManager.getLogger(CustomException.class);
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String error;

    public CustomException(String message) {
        super(message);
        logger.error(message);
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.error = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    public CustomException(String error, String message) {
        super(message);
        logger.error(message);
        this.timestamp = LocalDateTime.now();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.error = error;
    }

    public CustomException(HttpStatus status, String error, String message) {
        super(message);
        logger.error(message);
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }

    public CustomException(Throwable cause, HttpStatus status, String error, String message) {
        super(message, cause);
        logger.error(message);
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }
}