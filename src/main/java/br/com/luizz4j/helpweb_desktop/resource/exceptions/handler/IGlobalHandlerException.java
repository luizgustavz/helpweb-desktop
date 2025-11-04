package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler;

import br.com.luizz4j.helpweb_desktop.exceptions.CpfAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.EmailAlreadyRegisterException;
import br.com.luizz4j.helpweb_desktop.exceptions.IdNotFoundException;
import br.com.luizz4j.helpweb_desktop.resource.exceptions.handler.model.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IGlobalHandlerException {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> handlerIdNotFoundException(IdNotFoundException idNotFoundException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerFieldsInvalidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(EmailAlreadyRegisterException.class)
    public ResponseEntity<?> handlerEmailAlreadyRegisterException(EmailAlreadyRegisterException emailAlreadyRegisterException, HttpServletRequest httpServletRequest);

    @ExceptionHandler(CpfAlreadyRegisterException.class)
    public ResponseEntity<?> handlerCpfAlreadyRegisterException(CpfAlreadyRegisterException cpfAlreadyRegisterException, HttpServletRequest httpServletRequest);
}
