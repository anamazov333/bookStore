package com.company.bookstore.service.impl;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.dto.BookRequest;
import com.company.bookstore.entity.Book;
import com.company.bookstore.entity.User;
import com.company.bookstore.exception.CustomNotFoundException;
import com.company.bookstore.mapper.BookMapper;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.UserRepository;
import com.company.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.company.bookstore.util.Constants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public List<BookDto> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Page<Book> searchBooks(Integer page, Integer perPageSt, String search, String sort, String sortField) {
        log.info("books");
        Pageable pageable = getPageable(page, perPageSt, sort, sortField);
        Page<Book> booksByFilter = bookRepository.getBooksByFilter(pageable, search);

        return booksByFilter;
    }


    @Override
    public ResponseEntity<String> addBook(BookRequest bookRequest) {
        Book book = BookMapper.INSTANCE.bookRequestToBook(bookRequest);
        book.setUser(userRepository.findByEmail(bookRequest.getUserEmail()).orElse(null));
        bookRepository.save(book);
        return ResponseEntity.ok().body(SUCCESFULLY_CREATED);
    }

    @Override
    public ResponseEntity<String> editBook(BookDto bookDto) {
        Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);
        bookRepository.save(book);
        return ResponseEntity.ok().body(SUCCESFULLY_UPDATED);
    }

    @Override
    public ResponseEntity<BookDto> getBookById(Long id, String email) {

        Optional<User> user = userRepository.findByEmail(email);
        return ResponseEntity.ok().body(bookRepository.findBookById(id,user.get().getId())
                .orElseThrow(() -> new CustomNotFoundException(BOOK_NOT_FOUND)));

    }


    public static Pageable getPageable(Integer page, Integer perPageSt, String sort, String sortField) {
        Pageable pageable;
        if (sort.equals("asc")) {
            pageable = PageRequest.of(page - 1, perPageSt, Sort.by(sortField).ascending());
        } else {
            pageable = PageRequest.of(page - 1, perPageSt, Sort.by(sortField).descending());
        }
        return pageable;
    }


}
