package com.ht.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ht.domain.Room;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto extends  ResponseDto{

    private long id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private String special_request;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long room_id;

}
