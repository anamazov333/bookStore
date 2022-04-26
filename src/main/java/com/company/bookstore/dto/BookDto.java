package com.company.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String authorName;
    private String authorSurname;
    @JsonIgnore
    private String userEmail;
    public BookDto(String name) {
        this.name = name;
    }

    public BookDto(Long id, String name, String authorName, String authorSurname) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }
}
