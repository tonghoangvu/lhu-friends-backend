package com.tonghoangvu.lhufriendsbackend.common;

import lombok.Getter;
import org.jetbrains.annotations.Contract;

@Getter
public enum Const {
    MAX_STUDENTS_PER_REQUEST(100);

    private final int intValue;

    @Contract(pure = true)
    Const(int value) {
        this.intValue = value;
    }
}
