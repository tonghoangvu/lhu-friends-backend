package com.tonghoangvu.lhufriendsbackend.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PwaController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private static final String ERROR_REDIRECT = "forward:/";

    @RequestMapping(ERROR_PATH)
    public String error() {
        return ERROR_REDIRECT;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
