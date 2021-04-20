package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AppException extends RuntimeException {
    private final int status;
    private final ErrorCode code;
    private final String message;

    public AppException(HttpStatus status, ErrorCode code, String message) {
        super(message);
        this.status = status.value();
        this.code = code;
        this.message = message;
    }
}
