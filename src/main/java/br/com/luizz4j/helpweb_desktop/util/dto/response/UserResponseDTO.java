package br.com.luizz4j.helpweb_desktop.util.dto.response;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record UserResponseDTO(

        String name,

        String cpf,

        String email,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH-mm-ss")
        LocalDateTime createAt,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH-mm-ss")
        LocalDateTime updateAt,

        RoleEnums roles
) {
}
