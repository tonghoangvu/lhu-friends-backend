package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    private final @NotNull ErrorCode code;
    private final @NotNull String message;
}
