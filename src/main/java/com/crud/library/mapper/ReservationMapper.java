package com.crud.library.mapper;

import com.crud.library.domain.Reservation;
import com.crud.library.domain.ReservationDto;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {
    @Autowired
    DbService dbService;

    public Reservation mapToReservation (final ReservationDto reservationDto){
        return new Reservation(
                reservationDto.getId(),
                dbService.getReaderById(reservationDto.getId()),
                dbService.getBookById(reservationDto.getId()),
                reservationDto.getLoanDate(),
                reservationDto.getReturnDate()
        );
    }

    public ReservationDto mapToReservationDto (final Reservation reservation){
        return new ReservationDto(
                reservation.getId(),
                reservation.getReader().getId(),
                reservation.getBook().getId(),
                reservation.getLoanDate(),
                reservation.getReturnDate()
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservationList) {
        return reservationList.stream()
                .map(reservation -> new ReservationDto(
                        reservation.getId(),
                        reservation.getReader().getId(),
                        reservation.getBook().getId(),
                        reservation.getLoanDate(),
                        reservation.getReturnDate()
                ))
                .collect(Collectors.toList());
    }
}
