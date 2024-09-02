package com.railwayapplication.railwaybackend.controllers;

import com.railwayapplication.railwaybackend.models.Train;
import com.railwayapplication.railwaybackend.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainRepository trainRepository;

    @GetMapping("/searchByLocation")
    public List<Train> findTrainsByLocations(@RequestParam String startingLocation, @RequestParam String endLocation) {
        return trainRepository.findByStartLocationAndEndLocation(startingLocation, endLocation);
    }
}

