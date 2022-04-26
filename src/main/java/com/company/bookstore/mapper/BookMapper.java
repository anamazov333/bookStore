package com.company.bookstore.mapper;


import com.company.bookstore.dto.BookDto;
import com.company.bookstore.dto.BookRequest;
import com.company.bookstore.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book bookDtoToBook(BookDto request);


    @Mappings(value = {
            @Mapping(target = "id", ignore = true),
    })
    Book bookRequestToBook(BookRequest request);


}
