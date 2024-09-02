package com.railwayapplication.railwaybackend.repository;

import com.railwayapplication.railwaybackend.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
