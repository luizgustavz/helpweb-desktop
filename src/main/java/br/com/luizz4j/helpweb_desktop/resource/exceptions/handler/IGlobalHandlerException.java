package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler;

import br.com.luizz4j.helpweb_desktop.exceptions.IdNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IGlobalHandlerException {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> IdNotFoundHandlerException(IdNotFoundException idNotFoundException, HttpServletRequest httpServletRequest);

}
