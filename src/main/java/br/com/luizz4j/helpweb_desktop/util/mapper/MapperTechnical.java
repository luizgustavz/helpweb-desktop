package br.com.luizz4j.helpweb_desktop.util.mapper;

import br.com.luizz4j.helpweb_desktop.domain.Technical;
import br.com.luizz4j.helpweb_desktop.util.dto.request.UserRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperTechnical {

    @Mapping(target = "tickets", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Technical fromTechnical(UserRequestDTO technicalDTO);
}
