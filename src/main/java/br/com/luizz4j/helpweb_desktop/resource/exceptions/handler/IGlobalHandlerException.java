package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler;

import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketInOpenStatusException;
import br.com.luizz4j.helpweb_desktop.exceptions.ticket.TicketNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.ClientNotFoundException;
import br.com.luizz4j.helpweb_desktop.exceptions.user.PasswordDoesNotMatchException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IGlobalHandlerException {

    @ExceptionHandler(ClientNotFoundException.class)
    ResponseEntity<?> handlerIdNotFoundException(ClientNotFoundException CLientNotFoundException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> handlerFieldsInvalidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(EmailAlreadyRegisterException.class)
    ResponseEntity<?> handlerEmailAlreadyRegisterException(EmailAlreadyRegisterException emailAlreadyRegisterException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(CpfAlreadyRegisterException.class)
    ResponseEntity<?> handlerCpfAlreadyRegisterException(CpfAlreadyRegisterException cpfAlreadyRegisterException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(PasswordDoesNotMatchException.class)
    ResponseEntity<?> handlerPasswordDoesNotMatchException(PasswordDoesNotMatchException passwordDoesNotMatchException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(TicketNotFoundException.class)
    ResponseEntity<?> handlerTicketNotFoundException(TicketNotFoundException ticketNotFoundException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(TicketInOpenStatusException.class)
    ResponseEntity<?> handlerTicketInOpenStatusException(TicketInOpenStatusException ticketInOpenStatusException, HttpServletRequest httpServletRequest);

}
