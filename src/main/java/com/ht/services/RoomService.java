package com.ht.services;

import com.ht.domain.Room;
import com.ht.dto.RoomDto;
import com.ht.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PragayanshuShukla
 */
@AllArgsConstructor
@Service
public class RoomService {

    final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public RoomDto addRoom(RoomDto roomDto) {
        Room room = modelMapper.map(roomDto, Room.class);
        room = roomRepository.save(room);
        return modelMapper.map(room, RoomDto.class);
    }

    public List<RoomDto> getRooms() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomDto> roomDtos = rooms
                                .stream()
                                .map(x->modelMapper.map(x,RoomDto.class))
                                .toList();
        return roomDtos;
    }

}
