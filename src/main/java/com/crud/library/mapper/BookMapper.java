package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto){
        return new Book(
                bookDto.getId(),
                bookDto.getReaderId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYear(),
                bookDto.getDescription(),
                bookDto.getPurchaseDate(),
                bookDto.getLoanDate());
    }

    public BookDto mapToBookDto (final Book book){
        return new BookDto(
                book.getId(),
                book.getReaderId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                book.getDescription(),
                book.getPurchaseDate(),
                book.getLoanDate());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(book.getId(),
                        book.getReaderId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getDescription(),
                        book.getPurchaseDate(),
                        book.getLoanDate()))
                .collect(Collectors.toList());
    }
}

