package com.company.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String name;
    private String authorName;
    private String authorSurname;
    @JsonIgnore
    private String userEmail;

}
