package com.crud.library.domain;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name="books")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        //@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
        @Column(name="READER_ID")
        private Long readerId;

        @Column(name="TITLE")
        private String title;

        @Column(name="AUTHOR")
        private String author;

        @Column(name="YEAR")
        private Integer year;

        @Column(name="DESCRIPTION")
        private String description;


        @Column(name="PURCHASE_DATE")
        private LocalDate purchaseDate;

        @Column(name="LOAN_DATE")
        private LocalDate loanDate;

}
