package com.tonghoangvu.lhufriendsbackend.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PwaController implements ErrorController {
    private static final @NotNull String ERROR_PATH = "/error";
    private static final @NotNull String ERROR_REDIRECT = "forward:/";

    @RequestMapping(ERROR_PATH)
    public @NotNull String error() {
        return ERROR_REDIRECT;
    }

    @Override
    public @NotNull String getErrorPath() {
        return ERROR_PATH;
    }
}
