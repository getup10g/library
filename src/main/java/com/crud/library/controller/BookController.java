package com.crud.library.controller;

import com.crud.library.domain.BookDto;
import com.crud.library.domain.ReaderDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/v1/library")
public class BookController {


    @Autowired
    private DbService service;
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllBooks")
    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookById")
    public BookDto getBookById(@RequestParam Long bookId) {
        return bookMapper.mapToBookDto(service.getBookById(bookId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        service.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        service.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByTitleContaining")
    public List<BookDto> getBooksByTitleContaining(@RequestParam String title) {
        return bookMapper.mapToBookDtoList(service.getBooksByTitleContaining(title));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByAuthorContaining")
    public List<BookDto> getBooksByAuthorContaining(@RequestParam String author) {
        return bookMapper.mapToBookDtoList(service.getBooksByAuthorContaining(author));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooksByYear")
    public List<BookDto> getBooksByYear(@RequestParam Integer year) {
        return bookMapper.mapToBookDtoList(service.getBooksByYear(year));
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "getBooksByReaderId")
    public List<BookDto> getBooksByReaderId(@RequestParam Long id) {
        return bookMapper.mapToBookDtoList(service.getBooksByReaderId(id));
    }*/
}

