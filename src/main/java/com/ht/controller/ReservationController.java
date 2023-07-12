package com.ht.controller;

import com.ht.dto.ReservationDto;
import com.ht.dto.RoomDto;
import com.ht.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PragayanshuShukla
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(path = "reservation/add")
    public ResponseEntity<List<ReservationDto>> newReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.newReservation(reservationDto));
    }
    @PostMapping(path = "reservation/update")
    public ResponseEntity<ReservationDto> updateReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationService.updateReservation(reservationDto));
    }
    @GetMapping(path = "reservations")
    public ResponseEntity<List<ReservationDto>> reservations() {
        return ResponseEntity.ok(reservationService.reservation());
    }
    @GetMapping(path = "reservations/{customerId}")
    public ResponseEntity<List<ReservationDto>> reservations(@PathVariable long customerId) {
        return ResponseEntity.ok(reservationService.reservationByCustomer(customerId));
    }
}
