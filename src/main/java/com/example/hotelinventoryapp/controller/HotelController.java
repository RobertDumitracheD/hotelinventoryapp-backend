package com.example.hotelinventoryapp.controller;


import com.example.hotelinventoryapp.persistance.Room;
import com.example.hotelinventoryapp.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotelinventory/all")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getRooms() {
        try {
            return new ResponseEntity<>(hotelService.getRooms(), HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<List<Map<String, Object>>> getRoomById(@PathVariable int roomNumber) {
        try {
            return new ResponseEntity<>(hotelService.getRoomById(roomNumber), HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addRoom")
    public ResponseEntity<List<Map<String, Object>>> addRoom(@RequestBody Room newRoom) {
        try {
            return new ResponseEntity<>(hotelService.addRoom(newRoom), HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateRoom/{roomNumber}")
    public ResponseEntity<List<Map<String, Object>>> addRoom(@RequestBody Room newRoom, @PathVariable int roomNumber) {
        try {
            return new ResponseEntity<>(hotelService.updateRoom(newRoom, roomNumber), HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomNumber) {
        try {
            hotelService.deleteRoom(roomNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<Boolean> login(
            @PathVariable String username,
            @PathVariable String password
    ) {

        try {
            boolean login = hotelService.login(username, password);
            if (login) {
                return new ResponseEntity<>(login,HttpStatus.OK);
            }
        } catch (Exception e) {

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
