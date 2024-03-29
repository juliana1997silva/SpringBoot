package br.com.juliana.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.juliana.exceptions.ExceptionResponse;
import br.com.juliana.exceptions.ResourceNotFoundException;

//utiliza sempre que precisa concentrar algum tratamento que seria espalhado em todos os controllers
@ControllerAdvice 

@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    //exceções mais genericas
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(
        Exception ex, WebRequest request
        ) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
                );
                return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //exceções especifica para o endpoint /sum
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(
        Exception ex, WebRequest request
        ) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), 
                ex.getMessage(), 
                request.getDescription(false)
                );
                return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


}
