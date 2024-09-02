package com.railwayapplication.railwaybackend.repository;

import com.railwayapplication.railwaybackend.models.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByStartLocationAndEndLocation(String startingLocation, String endLocation);
}
