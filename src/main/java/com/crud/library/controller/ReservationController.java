package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.mapper.ReservationMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/v1/library")
public class ReservationController {

    @Autowired
    private DbService service;
    @Autowired
    private ReservationMapper reservationMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllReservations")
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.mapToReservationDtoList(service.getAllReservations());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservationById")
    public ReservationDto getReservationById(@RequestParam Long bookId) {
        return reservationMapper.mapToReservationDto(service.getReservationById(bookId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReservation")
    public void deleteReservation(@RequestParam Long id) {
        service.deleteBook(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReservation", consumes = APPLICATION_JSON_VALUE)
    public void createReservation(@RequestBody ReservationDto reservationDto) {
        service.saveReservation(reservationDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook", consumes = APPLICATION_JSON_VALUE)
    public void returnBook(@RequestBody ReservationDto reservationDto) {
        service.returnBook(reservationDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservationsByReaderId")
    public ReservationDto getReservationsByReaderId(@RequestParam Long id) throws ReservationNotFoundException {
        return reservationMapper.mapToReservationDto(service.getReservationsByReaderId(id).orElseThrow(ReservationNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservationsByBookId")
    public ReservationDto getReservationsByBookId(@RequestParam Long id) throws ReservationNotFoundException {
        return reservationMapper.mapToReservationDto(service.getReservationsByBookId(id).orElseThrow(ReservationNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservationsByLoanDate")
    public List<ReservationDto> getReservationsByLoanDate(@RequestParam LocalDateTime time) {
        return reservationMapper.mapToReservationDtoList(service.getReservationsByLoanDate(time));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReservationsByReturnDate")
    public List<ReservationDto> getReservationsByReturnDate(@RequestParam LocalDateTime time) {
        return reservationMapper.mapToReservationDtoList(service.getReservationsByReturnDate(time));
    }


}
