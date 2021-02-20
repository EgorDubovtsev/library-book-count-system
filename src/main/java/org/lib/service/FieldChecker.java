package org.lib.service;


import org.lib.dto.CreatedBookDTO;
import org.lib.dto.RegistredUserDTO;
import org.lib.entity.User;

public interface FieldChecker {
    boolean isNull(RegistredUserDTO registredUserDTO);

    boolean isNull(CreatedBookDTO createdBookDTO);

    boolean isNull(User user);
}
