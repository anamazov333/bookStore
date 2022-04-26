package com.company.bookstore.entity;

import com.company.bookstore.enumeration.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Book.TABLE_NAME)
public class Book implements Serializable {

    public static final String TABLE_NAME = "books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String authorName;
    private String authorSurname;

    @ManyToOne
    private User user;
}

