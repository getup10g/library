package com.crud.library.repository;

import com.crud.library.domain.Book;
import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    Optional<Book> findById(Long Id);

    List<Book> findByTitleContaining(String title);

    List<Book> findByAuthorContaining(String author);

    List<Book> findByYear(Integer Year);

    void delete(Long id);


}
