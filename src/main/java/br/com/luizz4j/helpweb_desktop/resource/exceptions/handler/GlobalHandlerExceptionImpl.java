package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler;

import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketInOpenStatusException;
import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.ClientNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.PasswordDoesNotMatchException;
import br.com.luizz4j.helpweb_desktop.resource.exceptions.handler.model.ApiError;
import br.com.luizz4j.helpweb_desktop.resource.exceptions.handler.model.StandardError;
import br.com.luizz4j.helpweb_desktop.resource.exceptions.message.StandardMessageError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalHandlerExceptionImpl implements IGlobalHandlerException {

    @Override
    public ResponseEntity<ApiError> handlerIdNotFoundException(ClientNotFoundException CLientNotFoundException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ApiError.builder()
                                .timestamp(LocalDateTime.now())
                                .code(HttpStatus.NOT_FOUND.value())
                                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                                .path(httpServletRequest.getRequestURI())
                                .build()
                );
    }

    @Override
    public ResponseEntity<StandardError> handlerFieldsInvalidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(StandardError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .erros(methodArgumentNotValidException
                                .getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(FieldError::getDefaultMessage)
                                .collect(Collectors.toSet()))
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );
    }

    @Override
    public ResponseEntity<?> handlerEmailAlreadyRegisterException(EmailAlreadyRegisterException emailAlreadyRegisterException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.CONFLICT.value())
                        .error(StandardMessageError.INVALID_EMAIL_REGISTER)
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );

    }

    @Override
    public ResponseEntity<?> handlerCpfAlreadyRegisterException(CpfAlreadyRegisterException cpfAlreadyRegisterException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.CONFLICT.value())
                        .error(StandardMessageError.INVALID_CPF_REGISTER)
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );
    }

    @Override
    public ResponseEntity<?> handlerPasswordDoesNotMatchException(PasswordDoesNotMatchException passwordDoesNotMatchException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.CONFLICT.value())
                        .error(StandardMessageError.PASSWORD_DOES_NOT_MATCH)
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );
    }

    @Override
    public ResponseEntity<?> handlerTicketNotFoundException(TicketNotFoundException ticketNotFoundException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.NOT_FOUND.value())
                        .error(StandardMessageError.TICKET_NOT_FOUND)
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );
    }

    @Override
    public ResponseEntity<?> handlerTicketInOpenStatusException(TicketInOpenStatusException ticketInOpenStatusException, HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiError.builder()
                        .timestamp(LocalDateTime.now())
                        .code(HttpStatus.CONFLICT.value())
                        .error(StandardMessageError.TICKET_IN_STATUS_OPEN)
                        .path(httpServletRequest.getRequestURI())
                        .build()
                );
    }
}
