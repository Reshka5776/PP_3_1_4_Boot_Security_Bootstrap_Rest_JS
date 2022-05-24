package ru.kata.spring.boot_security.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UsersIncorrectData> handleException(NoSuchUserException noSuchUserException) {

        UsersIncorrectData usersIncorrectData = new UsersIncorrectData();
        usersIncorrectData.setInfo(noSuchUserException.getMessage());

        return new ResponseEntity<>(usersIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UsersIncorrectData> handleException(Exception exception) {

        UsersIncorrectData usersIncorrectData = new UsersIncorrectData();
        usersIncorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(usersIncorrectData, HttpStatus.BAD_REQUEST);
    }
}


