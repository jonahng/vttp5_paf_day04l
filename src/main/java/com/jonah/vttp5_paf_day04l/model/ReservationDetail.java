package com.jonah.vttp5_paf_day04l.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetail {
    private int id;
    private Book book;
    private Reservation reservation;
    
}
