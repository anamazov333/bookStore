package com.company.bookstore.repository;

import com.company.bookstore.dto.BookDto;
import com.company.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select new com.company.bookstore.dto.BookDto(b.id,b.name,b.authorName,b.authorSurname) from Book b where b.name like %:search%")
    List<BookDto> getBooks();

    @Query(value = "select b from Book b where b.name like %:search%")
    Page<Book> getBooksByFilter(Pageable pageable,@Param("search") String search );


    @Query(value = "select new com.company.bookstore.dto.BookDto(b.id,b.name,b.authorName,b.authorSurname) from Book b  where b.user.id=:userId and b.id=:id")
    Optional<BookDto> findBookById(@Param("id") Long id,@Param("userId") Long userId);

}
