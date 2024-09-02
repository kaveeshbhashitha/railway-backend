package com.railwayapplication.railwaybackend.exceptions;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(Long id){
        super("Could not found the passenger with id "+id);
    }
}

