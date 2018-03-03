package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    private Long readerId;
    private String title;
    private String author;
    private Integer year;
    private String description;
    private LocalDate purchaseDate;
    private LocalDate loanDate;
}
