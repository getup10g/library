package com.crud.library.controller;


import com.crud.library.domain.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/v1/library")
public class ReaderController {
    @Autowired
    private DbService service;
    @Autowired
    private ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllReaders")
    public List<ReaderDto> getAllReaders() {
        return readerMapper.mapToReaderDtoList(service.getAllReaders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReader")
    public ReaderDto getReader(@RequestParam Long readerId) {
        return readerMapper.mapToReaderDto(service.getReaderById(readerId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId) {
        service.deleteReader(readerId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(service.saveReader(readerMapper.mapToReader(readerDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        service.saveReader(readerMapper.mapToReader(readerDto));
    }
}
