package com.crud.library.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS", nullable = false)
    private Boolean status = true;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations = new ArrayList<>();

}
