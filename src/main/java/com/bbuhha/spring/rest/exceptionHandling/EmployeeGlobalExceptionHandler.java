package com.bbuhha.spring.rest.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Класс, предоставляющий функциональность Global Exception Handler'a
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<EmployeeIncorrectData> handleExceptionNotFound(
            //В случае выбрасывания NoSuchEmployeeException мы должны добавить в тело Response добавить объект EmployeeIncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler //метод, ответственный за обработку исключений
    //ResponseEntity - обертка HTTP response
    public ResponseEntity<EmployeeIncorrectData> handleExceptionAny(
            //В случае выбрасывания любой ошибка мы должны добавить в тело Response добавить объект EmployeeIncorrectData
            //грубо говоря, на какой exception реагирует данный метод
            Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        //передаем сам объект, и статус код нашего HTTP-response
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
