package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final @NotNull ErrorCode code;
    private final @NotNull String message;
}
