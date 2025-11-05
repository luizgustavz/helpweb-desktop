package br.com.luizz4j.helpweb_desktop.util.dto.response.client;

import br.com.luizz4j.helpweb_desktop.domain.enums.RoleEnums;

public record ClientResponse(
        String name,
        String cpf,
        String email,
        RoleEnums roles
) {
}
