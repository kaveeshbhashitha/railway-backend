package com.railwayapplication.railwaybackend.exceptions;

public class PassengerNotFoundException extends RuntimeException{
    public PassengerNotFoundException(Long id){
        super("Could not found the passenger with id "+id);
    }
}

