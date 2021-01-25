package io.aadeesh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aadeesh.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
