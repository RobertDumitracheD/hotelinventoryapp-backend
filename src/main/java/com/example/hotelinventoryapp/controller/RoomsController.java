package com.example.hotelinventoryapp.controller;


import com.example.hotelinventoryapp.persistance.Room;
import com.example.hotelinventoryapp.service.RoomsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotelinventory/all")
public class RoomsController {


    private final RoomsService roomsSerivce;

    public RoomsController(RoomsService roomsService) {
        this.roomsSerivce= roomsService;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getRooms() {
        try{
            return new ResponseEntity<>(roomsSerivce.getRooms(), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{roomNumber}")
    public ResponseEntity<List<Map<String, Object>>> getRoomById(@PathVariable int roomNumber) {
        try{
            return new ResponseEntity<>(roomsSerivce.getRoomById(roomNumber), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addRoom")
    public ResponseEntity<List<Map<String, Object>>> addRoom(@RequestBody Room newRoom) {
        try{
            return new ResponseEntity<>(roomsSerivce.addRoom(newRoom), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateRoom/{roomNumber}")
    public ResponseEntity<List<Map<String, Object>>> addRoom(@RequestBody Room newRoom, @PathVariable  int roomNumber) {
        try{
            return new ResponseEntity<>(roomsSerivce.updateRoom(newRoom, roomNumber), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomNumber) {
        try{
            roomsSerivce.deleteRoom(roomNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
