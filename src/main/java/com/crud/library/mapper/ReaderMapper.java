package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.domain.ReaderDto;
import com.crud.library.domain.Reservation;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    @Autowired
    DbService dbService;

    public Reader mapToReader(final ReaderDto readerDto) {
        List<Reservation> reservations;
        reservations = readerDto.getReservationsIdList().stream().map(t -> dbService.getReservationById(t)).collect(Collectors.toList());
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstname(),
                readerDto.getLastname(),
                readerDto.getAdress(),
                readerDto.getPhoneNumber(),
                reservations
        );
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getAdress(),
                reader.getPhoneNumber(),
                reader.getReservations().stream().map(t -> t.getId())
                        .collect(Collectors.toList())
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDto(
                        t.getId(),
                        t.getFirstname(),
                        t.getLastname(),
                        t.getAdress(),
                        t.getPhoneNumber(),
                        t.getReservations().stream().map(r -> r.getId())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
