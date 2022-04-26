package com.company.bookstore.service;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.dto.BookRequest;
import com.company.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {


    List<BookDto> getBooks();
    Page<Book> searchBooks(Integer page, Integer perPageSt, String search, String sort, String sortField);

    ResponseEntity<String> addBook(BookRequest bookRequest);

    ResponseEntity<String> editBook(BookDto bookDto);

    ResponseEntity<BookDto>  getBookById(Long id, String email);
}
