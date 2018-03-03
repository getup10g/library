package com.crud.library.service;


import com.crud.library.domain.Book;
import com.crud.library.domain.Reader;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private ReaderRepository repository;

    @Autowired
    private BookRepository bookRepository;

    public List<Reader> getAllReaders() {
        return repository.findAll();
    }

    public Optional<Reader> getReader(final Long readerId) {
        return repository.findById(readerId);
    }

    public Reader saveReader(final Reader reader) {
        return repository.save(reader);
    }

    public void deleteReader(final Long id) {
        repository.delete(id);
    }

//Books

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(final Long bookId) {
        return bookRepository.findById(bookId);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook (final Long id) {
        bookRepository.delete(id);
    }

    public List<Book> getBooksByTitleContaining(final String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> getBooksByAuthorContaining(final String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    public List<Book> getBooksByYear(final Integer year) {
        return bookRepository.findByYear(year);
    }

    public List<Book> getBooksByReaderId(final Long id) {
        return bookRepository.findByReaderId(id);
    }
}
