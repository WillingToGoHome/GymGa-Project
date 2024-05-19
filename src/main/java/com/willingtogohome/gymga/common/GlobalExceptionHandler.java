package com.willingtogohome.gymga.common;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public String noResourceFoundException(NoResourceFoundException exception, Model model) {
        model.addAttribute("errorCode", exception.getStatusCode());
        model.addAttribute("errorMessage", "존재하지 않는 페이지입니다");
        return "/error/error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDeniedException(AccessDeniedException ex, Model model) {
        model.addAttribute("errorCode", HttpStatus.FORBIDDEN.value());
        model.addAttribute("errorMessage", "접근이 거부되었습니다.");
        return "/error/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Exception ex, Model model) {
        model.addAttribute("errorCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("errorMessage", "서버에 오류가 발생했습니다.");
        return "/error/error";
    }
}
