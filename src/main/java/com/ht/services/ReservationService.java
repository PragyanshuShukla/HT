package com.ht.services;

import com.auth0.jwt.JWT;
import com.ht.domain.Customer;
import com.ht.domain.Reservation;
import com.ht.domain.Room;
import com.ht.dto.ReservationDto;
import com.ht.repository.CustomerRepository;
import com.ht.repository.ReservationRepository;
import com.ht.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author PragayanshuShukla
 */
@AllArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    private final ModelMapper  modelMapper;

    public List<ReservationDto> newReservation(ReservationDto reservationDto) {
        Room room = roomRepository
                .findById(reservationDto.getRoom_id())
                .get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt principal = (Jwt) authentication.getPrincipal();
        long userId = Long.parseLong(principal.getClaims().get("userId").toString());
        Customer customer = customerRepository.findById(userId).get();
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation = reservationRepository.save(reservation);
        List<Reservation> reservations = reservationRepository.findReservationByCustomer(reservation.getCustomer());
        List<ReservationDto> reservationDtos = reservations
                .stream()
                .map(x -> modelMapper.map(x, ReservationDto.class)).toList();
        return reservationDtos;

    }

    public ReservationDto updateReservation(ReservationDto reservationDto) {
        Room room = roomRepository
                .findById(reservationDto.getRoom_id())
                .get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt principal = (Jwt) authentication.getPrincipal();
        long userId = Long.parseLong(principal.getClaims().get("userId").toString());
        Customer customer = customerRepository.findById(userId).get();
        Reservation reservation = modelMapper.map(reservationDto, Reservation.class);
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation = reservationRepository.save(reservation);
        modelMapper.map(reservation,Reservation.class);
        return modelMapper.map(reservation,ReservationDto.class);

    }

    public List<ReservationDto> reservation() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt principal = (Jwt) authentication.getPrincipal();
        long userId = Long.parseLong(principal.getClaims().get("userId").toString());
        Customer customer = customerRepository.findById(userId).get();
        List<Reservation> reservations = reservationRepository.findReservationByCustomer(customer);
        List<ReservationDto> reservationDtos = reservations
                .stream()
                .map(x -> modelMapper.map(x, ReservationDto.class)).toList();
        return reservationDtos;

    }
    public List<ReservationDto> reservationByCustomer(long customerID) {
        Customer customer = customerRepository.findById(customerID).get();
        List<Reservation> reservations = reservationRepository.findReservationByCustomer(customer);
        List<ReservationDto> reservationDtos = reservations
                .stream()
                .map(x -> modelMapper.map(x, ReservationDto.class)).toList();
        return reservationDtos;

    }

    public boolean isValidDate(ReservationDto reservationDto){

     return reservationDto.getCheck_out_date()
             .compareTo(reservationDto.getCheck_in_date()) >= 0;
    }
}
