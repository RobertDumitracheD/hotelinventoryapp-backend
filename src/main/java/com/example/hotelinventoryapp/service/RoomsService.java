package com.example.hotelinventoryapp.service;

import com.example.hotelinventoryapp.persistance.Room;
import com.example.hotelinventoryapp.persistance.RoomsDAO;
import org.jooq.SelectConditionStep;
import org.jooq.sources.tables.Rooms;
import org.jooq.sources.tables.records.RoomsRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.jooq.sources.tables.Rooms.ROOMS;

@Service
public class RoomsService {
    private RoomsDAO roomsDAO;

    public RoomsService(RoomsDAO roomsDAO) {
        this.roomsDAO = roomsDAO;
    }

    public List<Map<String, Object>> getRooms() {

        return roomsDAO.getRooms();
    }

    public List<Map<String, Object>> getRoomById(int roomNumber) {
       return roomsDAO.getRoomById(roomNumber);
    }

    public List<Map<String, Object>> addRoom(Room newRoom) {
        return roomsDAO.addRoom(newRoom);
    }

    public void deleteRoom(int roomNumber) {
        roomsDAO.deleteRoom(roomNumber);
    }

    public  List<Map<String, Object>> updateRoom(Room newRoom, int roomNumber) {
        return roomsDAO.updateRoom(newRoom, roomNumber);
    }
}
