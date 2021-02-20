package org.lib.mappers;


import org.lib.dto.RegistredUserDTO;
import org.lib.entity.User;

public interface UserMapper {
    User mapFromDto(RegistredUserDTO registredUserDTO);
}
