package org.lib.service;


import org.lib.dto.BookDTO;
import org.lib.dto.RegistredUserDTO;
import org.lib.entity.User;

public interface FieldChecker {
    boolean isNull(RegistredUserDTO registredUserDTO);

    boolean isNull(BookDTO createdBookDTO);

    boolean isNull(User user);
}
