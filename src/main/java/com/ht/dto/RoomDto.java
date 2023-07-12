package com.ht.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PragayanshuShukla
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;
    private String description;
    private int number_of_person;
    private boolean have_private_bathroom;
    private double price;
}
