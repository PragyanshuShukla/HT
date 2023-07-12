package com.ht.controller;

import com.ht.dto.CustomerDto;
import com.ht.dto.RoomDto;
import com.ht.services.RoomService;
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
public class RoomController {

    private final RoomService roomService;

    @PostMapping(path = "room/add")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
        return ResponseEntity.ok( roomService.addRoom(roomDto));
    }

    @GetMapping(path = "room")
    public ResponseEntity<List<RoomDto>> getRooms() {
        return ResponseEntity.ok( roomService.getRooms());
    }

}
