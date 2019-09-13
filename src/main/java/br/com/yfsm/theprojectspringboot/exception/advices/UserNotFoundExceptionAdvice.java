package br.com.yfsm.theprojectspringboot.exception.advices;

import br.com.yfsm.theprojectspringboot.exception.UserNotFoundException;
import br.com.yfsm.theprojectspringboot.response.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Error UserNotFoundHandler(UserNotFoundException ex) {
        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.toString());
        error.setDescription(ex.getMessage());
        error.setType("UserNotFoundException");
        return error;
    }
}
