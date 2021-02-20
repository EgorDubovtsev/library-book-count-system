package org.lib.service;


import org.lib.dto.CreatedBookDTO;
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
    public boolean isNull(CreatedBookDTO createdBookDTO) {
        return createdBookDTO == null
                ||createdBookDTO.getName().trim().equals("")
                || createdBookDTO.getAuthor().trim().equals("")
                || createdBookDTO.getDescription().trim().equals("")
                || createdBookDTO.getGenre().equals("null")
                || createdBookDTO.getPrice() == 0
                || createdBookDTO.getPublishYear() == 0;
    }

    @Override
    public boolean isNull(User user) {
        return user == null
                || user.getName().equals("")
                || user.getPassword().equals("")
                || user.getLogin().equals("");
    }
}
