package com.example.hotelinventoryapp.persistance;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int roomNumber;
    private String roomType;
    private double roomPrice;
    private String amenities;
    private double rating;

}
