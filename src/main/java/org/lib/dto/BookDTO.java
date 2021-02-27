package org.lib.dto;

import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookDTO {
    private String name;
    private String author;
    private String genre;
    private boolean isOccupied;
    private LocalDate returnDate;
    private String ownerName = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormattedDate() {
        return returnDate == null ? "" : returnDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public String getAuthor() {
        return author;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BookDTO() {
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isOccupied=" + isOccupied +
                ", returnDate=" + returnDate +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
