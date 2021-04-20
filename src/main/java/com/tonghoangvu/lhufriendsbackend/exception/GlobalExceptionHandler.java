package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    protected @NotNull ResponseEntity<Mono<ErrorResponse>> handleAppException(@NotNull AppException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getCode(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(Mono.just(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    protected @NotNull ResponseEntity<Mono<ErrorResponse>> handleUnwantedException(Exception e) {
        // Hide error details from client, only show in log
        log.error("Ops!", e);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.SERVER_ERROR, "Internal Server Error");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Mono.just(errorResponse));
    }
}
