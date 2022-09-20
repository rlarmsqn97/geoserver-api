package jbt.boo.some.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> errorHandler(MethodArgumentNotValidException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("code","400");
        result.put("message",e.getFieldError().getDefaultMessage());
        return result;
    }
}
