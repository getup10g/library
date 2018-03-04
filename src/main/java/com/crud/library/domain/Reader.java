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
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;

    @OneToMany(
            targetEntity = Reservation.class,
            mappedBy = "reader")
    private List<Reservation> reservations = new ArrayList<>();
}