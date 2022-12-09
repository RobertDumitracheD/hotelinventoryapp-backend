package com.example.hotelinventoryapp.service;

import com.example.hotelinventoryapp.persistance.Room;
import com.example.hotelinventoryapp.persistance.HotelDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    private HotelDAO hotelDAO;

    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public List<Map<String, Object>> getRooms() {

        return hotelDAO.getRooms();
    }

    public List<Map<String, Object>> getRoomById(int roomNumber) {
       return hotelDAO.getRoomById(roomNumber);
    }

    public List<Map<String, Object>> addRoom(Room newRoom) {
        return hotelDAO.addRoom(newRoom);
    }

    public void deleteRoom(int roomNumber) {
        hotelDAO.deleteRoom(roomNumber);
    }

    public  List<Map<String, Object>> updateRoom(Room newRoom, int roomNumber) {
        return hotelDAO.updateRoom(newRoom, roomNumber);
    }

    public boolean login(String username, String password) {
        List<Map<String, Object>> login = hotelDAO.login(username, password);
        if(!login.isEmpty()) {
            return true;
        }
        return false;
    }
}
