package com.jonah.vttp5_paf_day04l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonah.vttp5_paf_day04l.model.Reservation;
import com.jonah.vttp5_paf_day04l.model.ReservationDetail;
import com.jonah.vttp5_paf_day04l.repo.ReservationRepo;

@Service
public class ReservationService {
    @Autowired
    ReservationRepo reservationRepo;
    

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetail reservationDetail){
        Boolean bCreated = false;
        int iReservationId = reservationRepo.createReservation(reservation);
        //To simulate error,  
        //throw new IllegalArgumentException("just a fake error");
        reservationDetail.getReservation().setId(iReservationId);
        reservationRepo.createReservationDetails(reservationDetail);
        bCreated = true;
        return bCreated;

    }


}
