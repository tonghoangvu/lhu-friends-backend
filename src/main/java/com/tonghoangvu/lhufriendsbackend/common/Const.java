package com.tonghoangvu.lhufriendsbackend.common;

import lombok.Getter;

@Getter
public enum Const {
    MAX_STUDENTS_PER_REQUEST(100);

    private final int intValue;

    Const(int value) {
        this.intValue = value;
    }
}
