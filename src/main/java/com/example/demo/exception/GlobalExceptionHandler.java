//package com.example.demo.exception;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Collections;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity handleMissingParameter(MissingServletRequestParameterException ex) {
//        return ResponseEntity.ok(Collections.singletonMap(-1, "Không có tham số " + ex.getParameterName()));
//    }}
