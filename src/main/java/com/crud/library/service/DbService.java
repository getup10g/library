package com.crud.library.service;


import com.crud.library.domain.*;
import com.crud.library.mapper.BookMapper;
import com.crud.library.mapper.ReservationMapper;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.ReaderRepository;
import com.crud.library.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    private ReaderRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private BookMapper bookMapper;


    public List<Reader> getAllReaders() {
        return repository.findAll();
    }

    public Reader getReaderById(final Long readerId) {
        return repository.findById(readerId).orElse(null);
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

    public Book getBookById(final Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(final Long id) {
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

    public void changeStatus(final Boolean status, Long id) {
        BookDto bookDto2 = bookMapper.mapToBookDto(getBookById(id));

        if (status) {
            bookDto2.setStatus(true);
        } else {
            bookDto2.setStatus(false);
        }
        saveBook(bookMapper.mapToBook(bookDto2));
    }

    //Reservations

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(final Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Optional<Reservation> getReservationsByReaderId(final Long id) {
        return reservationRepository.findByReaderId(id);
    }

    public Optional<Reservation> getReservationsByBookId(final Long id) {
        return reservationRepository.findByBookId(id);
    }

    public Reservation saveReservation(final ReservationDto reservationDto) {

        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        changeStatus(false, reservationDto.getBookId());
        reservation.setBook(getBookById(reservationDto.getBookId()));
        reservation.setReader(getReaderById(reservationDto.getReaderId()));
        return reservationRepository.save(reservation);
    }

    public Reservation returnBook(final ReservationDto reservationDto) {
        ReservationDto reservationDto2 = reservationMapper.mapToReservationDto(getReservationById(reservationDto.getId()));
        if (reservationDto.getLoanDate() == null) {
            reservationDto.setLoanDate(reservationDto2.getLoanDate());
        }
        Reservation reservation = reservationMapper.mapToReservation(reservationDto);
        changeStatus(true, reservationDto.getBookId());
        reservation.setBook(getBookById(reservationDto2.getBookId()));

        reservation.setReader(getReaderById(reservationDto2.getReaderId()));

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(final Long id) {
        reservationRepository.delete(id);
    }

    public List<Reservation> getReservationsByLoanDate(final LocalDateTime time) {
        return reservationRepository.findByLoanDateAfter(time);
    }

    public List<Reservation> getReservationsByReturnDate(final LocalDateTime time) {
        return reservationRepository.findByReturnDateAfter(time);
    }


}
