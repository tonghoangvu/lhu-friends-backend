package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException {
    private final HttpStatus status;
    private final ErrorCode code;
    private final String message;
}
