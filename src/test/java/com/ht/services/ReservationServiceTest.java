package com.ht.services;

import com.HtApplication;
import com.ht.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author PragayanshuShukla
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;
    @Test
    void isValidDate() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setCheck_out_date(LocalDate.parse("2020-03-13",dateTimeFormatter));
        reservationDto.setCheck_in_date(LocalDate.parse("2020-03-12",dateTimeFormatter));
        boolean actual = reservationService.isValidDate(reservationDto);

        assertTrue(actual);
    }
}