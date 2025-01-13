package com.jonah.vttp5_paf_day04l.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day04l.model.Reservation;
import com.jonah.vttp5_paf_day04l.model.ReservationDetail;
import com.jonah.vttp5_paf_day04l.service.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("")
    public ResponseEntity<Boolean> makeReservation(@RequestBody ReservationDetail reservation){

            Boolean bCreatedReservation = reservationService.createReservationRecord(reservation.getReservation(), reservation);
            return ResponseEntity.ok().body(bCreatedReservation);
        
    }
    
}
