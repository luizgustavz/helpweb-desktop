package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApiError {

    private LocalDateTime timestamp;
    private Integer code;
    private String error;
    private String path;

}
