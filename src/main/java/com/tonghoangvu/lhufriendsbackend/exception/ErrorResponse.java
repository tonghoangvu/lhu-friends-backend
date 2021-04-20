package com.tonghoangvu.lhufriendsbackend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final ErrorCode code;
    private final String message;
}
