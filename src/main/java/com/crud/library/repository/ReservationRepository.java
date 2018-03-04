package com.crud.library.repository;

import com.crud.library.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Override
    List<Reservation> findAll();

    @Override
    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long Id);

    Optional<Reservation> findByReaderId(Long Id);

    Optional<Reservation> findByBookId(Long Id);

    List<Reservation> findByLoanDateAfter(LocalDateTime time);

    List<Reservation> findByReturnDateAfter(LocalDateTime time);

    void delete(Long id);
}
