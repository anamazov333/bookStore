package com.company.bookstore.controller;

import com.company.bookstore.dto.*;
import com.company.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/searchBooks")
    ResponseEntity<?> searchBooks(
            @RequestParam() Integer page,
            @RequestParam() Integer perPageSt,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam() String search,
            @RequestParam(defaultValue = "desc") String sort) {
        log.info("/books, page ={}, perPage = {}, search = {} , sort ={}, sortField ={}", page, perPageSt, search, sort, sortField);
        return ResponseEntity.ok().body(bookService.searchBooks(page, perPageSt, search, sort, sortField));
    }

    @GetMapping("/getBooks")
    ResponseEntity<?> getBooks() {
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @PreAuthorize("hasRole('ROLE_PUBLISHER')")
    @PostMapping("/add")
    ResponseEntity<String> addBook(@RequestBody BookRequest bookRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        bookRequest.setUserEmail(authentication.getName());
        return bookService.addBook(bookRequest);
    }

    @PreAuthorize("hasRole('ROLE_PUBLISHER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(name = "id") Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return bookService.getBookById(id, authentication.getName());
    }

    @PreAuthorize("hasRole('ROLE_PUBLISHER')")
    @PutMapping("/edit")
    ResponseEntity<String> editBook(@RequestBody BookDto bookDto) {
        return bookService.editBook(bookDto);
    }
}
