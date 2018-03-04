package com.crud.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "LOAN_DATE")
    private LocalDateTime loanDate;

    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDate;

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

