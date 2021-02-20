package org.lib.dto;

public class SimpleSearchParameters implements SearchParametersDTO {
    private String name;
    private String genre;
    private String maxPrice;
    private String author;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getMaxPrice() {
        return maxPrice;
    }

    @Override
    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
}
