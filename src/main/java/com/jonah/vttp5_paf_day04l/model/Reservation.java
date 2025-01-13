package com.jonah.vttp5_paf_day04l.model;

import java.sql.Date; //use the sql date for sql

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private int id;
    private String fullName;
    private Date reservationDate;
    
}
