package org.lib.dto;

public interface CreatedBookDTO {
    String getName();

    void setName(String name);

    String getAuthor();

    void setAuthor(String author);

    String getGenre();

    void setGenre(String genre);

    int getPublishYear();

    void setPublishYear(int publishYear);

    int getPrice();

    void setPrice(int price);

    String getDescription();

    void setDescription(String description);
}
