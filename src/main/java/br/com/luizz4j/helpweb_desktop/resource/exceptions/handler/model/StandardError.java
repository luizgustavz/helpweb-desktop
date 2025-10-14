package br.com.luizz4j.helpweb_desktop.resource.exceptions.handler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record StandardError(

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp,

        Integer code,
        Set<String> erros,
        String path
) {

}
