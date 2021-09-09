package ru.irlix.evaluation.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.irlix.evaluation.config.UTF8Control;
import ru.irlix.evaluation.utils.constant.LocaleConstants;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Log4j2
@ControllerAdvice
public class AppExceptionHandler {

    private final Locale locale = LocaleConstants.DEFAULT_LOCALE;
    private final ResourceBundle messageBundle = ResourceBundle.getBundle("messages", locale, new UTF8Control());
    private final String errorMessage = messageBundle.getString("validation.error");

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        ApiError apiError = new ApiError(errorMessage);
        apiError.setErrors(ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList()));
        log.error(apiError.getMessage() + " " + apiError.getErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        ApiError apiError = new ApiError(e.getMessage());
        log.error(e.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleBindException(BindException ex) {
        ApiError apiError = new ApiError(errorMessage);
        apiError.setErrors(ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList()));
        log.error(apiError.getMessage() + " " + apiError.getErrors());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}