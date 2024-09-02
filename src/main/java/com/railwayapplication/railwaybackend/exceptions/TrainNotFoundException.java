package com.railwayapplication.railwaybackend.exceptions;

public class TrainNotFoundException extends RuntimeException{
    public TrainNotFoundException(Long id) {
        super("Could not found the passenger with id " + id);
    }
}