package io.aadeesh.services;

import io.aadeesh.controller.dto.ReservationRequest;
import io.aadeesh.models.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
