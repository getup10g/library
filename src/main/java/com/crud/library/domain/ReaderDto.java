package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class ReaderDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String adress;
    private Integer phoneNumber;
    private List<Long> reservationsIdList = new ArrayList<>();
}
