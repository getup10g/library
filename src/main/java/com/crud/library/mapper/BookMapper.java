package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookDto;
import com.crud.library.domain.Reservation;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    DbService dbService;

    public Book mapToBook(final BookDto bookDto) {
        List<Reservation> reservations;
        reservations = bookDto.getReservationsIdList().stream().map(t -> dbService.getReservationById(t)).collect(Collectors.toList());

        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getYear(),
                bookDto.getDescription(),
                bookDto.getStatus()
                , reservations
        );

    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getYear(),
                book.getDescription(),
                book.getStatus()
                , book.getReservations().stream().map(t -> t.getId())
                .collect(Collectors.toList())
        );
    }


    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(book -> new BookDto(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYear(),
                        book.getDescription(),
                        book.getStatus()
                        , book.getReservations().stream().map(t -> t.getId())
                        .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}

