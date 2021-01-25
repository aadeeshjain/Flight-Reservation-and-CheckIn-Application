package io.aadeesh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aadeesh.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
