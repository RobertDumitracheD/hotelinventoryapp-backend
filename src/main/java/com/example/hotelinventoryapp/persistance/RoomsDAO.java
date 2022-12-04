package com.example.hotelinventoryapp.persistance;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Rooms;
import org.jooq.sources.tables.records.RoomsRecord;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.jooq.sources.tables.Rooms.ROOMS;

@Repository
public class RoomsDAO {


    DSLContext dslContext = DSL.using(createConnection(), SQLDialect.MYSQL);

    public RoomsDAO() throws SQLException {
    }

    public List<Map<String, Object>> getRooms() {
        List<Map<String, Object>> roomsRecords = dslContext.selectFrom(ROOMS).fetchMaps();

        return roomsRecords;
    }

    public List<Map<String, Object>> getRoomById(int roomNumber) {
        return dslContext.selectFrom(ROOMS).where(ROOMS.ROOMNUMBER.eq(roomNumber)).fetchMaps();
    }

    public List<Map<String, Object>> addRoom(Room newRoom) {
         dslContext.insertInto(ROOMS)
                .set(ROOMS.ROOMTYPE, newRoom.getRoomType())
                .set(ROOMS.ROOMPRICE, newRoom.getRoomPrice())
                .set(ROOMS.AMENITIES, newRoom.getAmenities())
                .set(ROOMS.RATING, newRoom.getRating())
                .execute();
        return dslContext.selectFrom(ROOMS).fetchMaps();
    }

    public List<Map<String, Object>> updateRoom(Room newRoom, int roomNumber) {

        dslContext.update(ROOMS)
                .set(ROOMS.ROOMTYPE, newRoom.getRoomType())
                .set(ROOMS.ROOMPRICE, newRoom.getRoomPrice())
                .set(ROOMS.AMENITIES, newRoom.getAmenities())
                .set(ROOMS.RATING, newRoom.getRating())
                .where(ROOMS.ROOMNUMBER.eq(roomNumber))
                .execute();
        return dslContext.selectFrom(ROOMS).fetchMaps();
    }

    public void deleteRoom(int roomNumber) {
        dslContext.deleteFrom(ROOMS).where(ROOMS.ROOMNUMBER.eq(roomNumber)).execute();
    }

    private Connection createConnection() throws SQLException {
        String url
                = "jdbc:mysql://localhost:3306/hotelinventoryapp";
        String username = "root"; // MySQL credentials
        String password = "rahatul49";

        return DriverManager.getConnection(
                url, username, password);
    }

}
