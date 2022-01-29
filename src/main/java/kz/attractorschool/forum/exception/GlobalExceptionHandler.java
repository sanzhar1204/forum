package kz.attractorschool.forum.exception;

import static java.util.stream.Collectors.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  protected ResponseEntity<Object> handleBindException(MethodArgumentNotValidException ex) {
    var bindingResult = ex.getBindingResult();

    var apiFieldErrors = bindingResult
        .getFieldErrors()
        .stream()
        .map(fe -> String.format("%s -> %s", fe.getField(), fe.getDefaultMessage()))
        .collect(toList());

    return ResponseEntity.badRequest()
        .body(apiFieldErrors);
  }

}
