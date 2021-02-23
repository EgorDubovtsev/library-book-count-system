package org.lib.service;


import org.lib.dto.BookDTO;
import org.lib.dto.RegistredUserDTO;
import org.lib.entity.User;

public class FieldCheckerService implements FieldChecker {
    @Override
    public boolean isNull(RegistredUserDTO registredUserDTO) {
        return registredUserDTO == null
                || registredUserDTO.getName().trim().equals("")
                || registredUserDTO.getPassword().trim().equals("")
                || registredUserDTO.getLogin().trim().equals("");
    }

    @Override
    public boolean isNull(BookDTO createdBookDTO) {
        return createdBookDTO == null
                ||createdBookDTO.getName().trim().equals("")
                || createdBookDTO.getAuthor().trim().equals("")
                || createdBookDTO.getGenre().equals("null");
    }

    @Override
    public boolean isNull(User user) {
        return user == null
                || user.getName().equals("")
                || user.getPassword().equals("")
                || user.getLogin().equals("");
    }
}
