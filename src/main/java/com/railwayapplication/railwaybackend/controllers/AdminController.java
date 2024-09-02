package com.railwayapplication.railwaybackend.controllers;

import com.railwayapplication.railwaybackend.exceptions.PassengerNotFoundException;
import com.railwayapplication.railwaybackend.models.Passenger;
import com.railwayapplication.railwaybackend.models.Train;
import com.railwayapplication.railwaybackend.repository.PassengerRepository;
import com.railwayapplication.railwaybackend.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping("/train/add")
    Train newUser(@RequestBody Train newUser){
        return trainRepository.save(newUser);
    }
    @GetMapping("/train/searchAll")
    List<Train> getAllUsers(){
        return trainRepository.findAll();
    }
    @GetMapping("/train/search/{id}")
    Train getUserById(@PathVariable Long id){
        return trainRepository.findById(id).orElseThrow(()->new PassengerNotFoundException(id));
    }
    @PutMapping("/train/update/{id}")
    Train updateUser(@RequestBody Train newTrain, @PathVariable Long id){
        return trainRepository.findById(id).map(trains -> {
            trains.setTrainNumber(newTrain.getTrainNumber());
            trains.setTrainClass(newTrain.getTrainClass());
            trains.setStops(newTrain.getStops());
            trains.setNumberOfSeats(newTrain.getNumberOfSeats());
            trains.setDayOfWeek(newTrain.getDayOfWeek());
            trains.setArrivalTime(newTrain.getArrivalTime());
            trains.setDepartureTime(newTrain.getDepartureTime());
            trains.setStartLocation(newTrain.getStartLocation());
            trains.setEndLocation(newTrain.getEndLocation());
            trains.setChargeTrain(newTrain.getChargeTrain());
            return trainRepository.save(trains);
        }).orElseThrow(()->new PassengerNotFoundException(id));
    }

    @DeleteMapping("/train/delete/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!trainRepository.existsById(id)) {
            throw new PassengerNotFoundException(id);
        }
        trainRepository.deleteById(id);
        return "Train with id " + id + " has been deleted successfully.";
    }
    //Passenger operation
    @GetMapping("/passenger/searchAll")
    List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    @GetMapping("/passenger/search/{id}")
    Passenger getPassengerById(@PathVariable Long id){
        return passengerRepository.findById(id).orElseThrow(()->new PassengerNotFoundException(id));
    }
    @PutMapping("/passenger/update/{id}")
    Passenger updatePassenger(@RequestBody Passenger newPassenger, @PathVariable Long id){
        return passengerRepository.findById(id).map(passenger -> {
            passenger.setFirstName(newPassenger.getFirstName());
            passenger.setLastName(newPassenger.getLastName());
            passenger.setMobileNo(newPassenger.getMobileNo());
            passenger.setNicNo(newPassenger.getNicNo());
            passenger.setEmail(newPassenger.getEmail());
            passenger.setPassword(newPassenger.getPassword());
            passenger.setConfPassword(newPassenger.getConfPassword());
            return passengerRepository.save(passenger);
        }).orElseThrow(()->new PassengerNotFoundException(id));
    }

    @DeleteMapping("/passenger/delete/{id}")
    String deletePassenger(@PathVariable Long id){
        if(!passengerRepository.existsById(id)){
            throw new PassengerNotFoundException(id);
        }
        passengerRepository.deleteById(id);
        return "Passenger with id "+id+" has been deleted successfully.";
    }

    //Passenger operations

}
//http://localhost:8080/trains/searchByLocation?startingLocation=Gampaha&endLocation=Fort